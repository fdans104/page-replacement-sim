/**
 * # Clock (Second Chance) Algorithm for Memory Management Simulation
 * This class simulates the Clock page replacement algorithm.
 * It gives a "second chance" to recently used pages by using a circular pointer and reference bits.
 */
public class Clock {
    public int execute(int[] pages, int capacity) {
        // Variables
        int[] memory = new int[capacity]; // Memory slots
        boolean[] referenceBit = new boolean[capacity]; // Reference bits for each page
        int pointer = 0; // Clock hand pointer
        int pageFaults = 0;

        // Initialize memory to -1 (empty)
        for (int i = 0; i < capacity; i++) {
            memory[i] = -1;
            referenceBit[i] = false;
        }

        for (int page : pages) {
            boolean pageInMemory = false;

            // Check if the page is already in memory
            for (int i = 0; i < capacity; i++) {
                if (memory[i] == page) {
                    referenceBit[i] = true; // Give a second chance
                    pageInMemory = true;
                    break;
                }
            }

            // If not in memory, handle page fault
            if (!pageInMemory) {
                while (true) {
                    if (!referenceBit[pointer]) {
                        // Replace page at pointer position
                        memory[pointer] = page;
                        referenceBit[pointer] = true; // Set reference bit for new page
                        pointer = (pointer + 1) % capacity; // Move pointer forward
                        pageFaults++;
                        break;
                    } else {
                        // Give a second chance and move the clock hand
                        referenceBit[pointer] = false;
                        pointer = (pointer + 1) % capacity;
                    }
                }
            }
        }

        return pageFaults;
    }
}
