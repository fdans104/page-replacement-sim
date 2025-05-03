/**
 * # Aging Algorithm for Memory Management Simulation
 * This class simulates the Aging page replacement algorithm.
 * Each page has an aging counter that shifts over time, tracking how recently it was used.
 */
public class Aging {
    public int execute(int[] pages, int capacity) {
        int[] memory = new int[capacity];             // Memory slots
        int[] agingCounter = new int[capacity];        // Aging counters for each slot
        boolean[] referenced = new boolean[capacity];  // Track reference bits
        int pageFaults = 0;

        // Initialize memory slots
        for (int i = 0; i < capacity; i++) {
            memory[i] = -1;
            agingCounter[i] = 0;
            referenced[i] = false;
        }

        for (int page : pages) {
            //Sets page inMemory to false by Default.
            boolean pageInMemory = false;

            // Step 1: Check if the page is already in memory
            for (int i = 0; i < capacity; i++) {
                if (memory[i] == page) {
                    //If it is: sets referenced to true. Sets pageInMemory to true. Break loop.
                    referenced[i] = true;
                    pageInMemory = true;
                    break;
                }
            }

            // Step 2: If not in memory, we must replace a page
            if (!pageInMemory) {
                int minIndex = 0; //Default index to be replaced

                for (int i = 1; i < capacity; i++) { // loop to choose the page to be replaced based on age.
                    // check if the current page (i) is older (has a smaller aging counter) than the page at minIndex.
                    if (agingCounter[i] < agingCounter[minIndex]) {
                        //If it is... set minIndex to (i) value.
                        minIndex = i;
                    }
                }

                // Replace the page with the oldest (smallest counter)
                memory[minIndex] = page;
                agingCounter[minIndex] = 0;
                referenced[minIndex] = true;
                pageFaults++;
            }

            // Step 3: Shift aging counters to the right, and update MSB if referenced
            for (int i = 0; i < capacity; i++) {
                agingCounter[i] >>= 1; //Shifts all bits in the aging counter one position to the right (equivalent to dividing the number by 2)
                if (referenced[i]) {
                    agingCounter[i] |= 1 << 7; // Set MSB (Most Significant Bit). This makes this page younger.
                    //Here we can see more how it works:
                    //System.out.println("Page: " + memory[i]);
                    //System.out.println("in Memory position: " + i);
                    //System.out.println("aging counter: " + agingCounter[i]);
                    //System.out.println("---");
                    referenced[i] = false;
                }
            }
        }

        return pageFaults;
    }
}
