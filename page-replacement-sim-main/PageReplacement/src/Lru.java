/**
 * # LRU (Least Recently Used) Algorithm for Memory Management Simulation
 * This class simulates the LRU page replacement algorithm. LRU replaces the least recently used page in memory
 * when a new page needs to be loaded.
 */
public class Lru {
    public int execute(int[] pages, int capacity) {
        // Variables
        int[] memory = new int[capacity]; // Defines memory slots
        int[] lastUsed = new int[capacity]; // Stores the "last used time" for each slot
        int pageFaults = 0; // Default page fault counter
        int time = 0; // Simulated "clock" to track usage recency

        // Initialize memory to -1 (empty)
        for (int i = 0; i < capacity; i++) {
            memory[i] = -1;
            lastUsed[i] = -1;
        }

        for (int page : pages) {
            time++; // Age (Increase time)
            boolean pageInMemory = false;

            // Check if the page is already in memory
            for (int i = 0; i < capacity; i++) {
                if (memory[i] == page) {
                    pageInMemory = true;
                    lastUsed[i] = time; // Update usage time, setting to current TIME value.
                    break;
                }
            }

            // If page is not in memory, need to replace
            if (!pageInMemory) {
                int lruIndex = 0;
                int minTime = Integer.MAX_VALUE; //Set minTime to the max value of an Integer. (It could be initialized with lastUsed[0])

                // Find the least recently used page (smallest lastUsed time / younger page)
                for (int i = 0; i < capacity; i++) {
                    if (lastUsed[i] < minTime) {
                        minTime = lastUsed[i];
                        lruIndex = i;
                    }
                }

                // Replace LRU page
                memory[lruIndex] = page;
                lastUsed[lruIndex] = time;
                pageFaults++;
            }
        }

        return pageFaults; // Return the total number of page faults
    }
}

