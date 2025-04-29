/**
 * # FIFO (First-In, First-Out) Algorithm for Memory Management Simulation
 * This class simulates the FIFO page replacement algorithm. FIFO replaces the oldest page in memory,
 * regardless of how often it has been used.
 */
public class Fifo {
    public int execute(int[] pages, int capacity) {
        //Variables
        int[] memory = new int[capacity]; //Defines each memory slot. The number of spaces is defined by "capacity" variable.
        int pageFaults = 0; //Default page faults set to 0.
        int pointer = 0;//Default pointer position set to 0.

        //Every memory slot set to -1 (Granting it will be NULL)
        for (int i = 0; i < capacity; i++) {
            memory[i] = -1;
        }

        for (int page : pages) {
            //Sets page inMemory to false by Default. (It maybe change later)
            boolean pageInMemory = false;

            for (int i = 0; i < capacity; i++) {
                //Check if page is in any of the memory slots
                if (memory[i] == page) {
                    //If it is... set pageInMemory to true, and breaks the for loop.
                    pageInMemory = true;
                    break;
                }
            }

            //If page is not on any of page loops:
            if (!pageInMemory) {
                memory[pointer] = page; // Pointer dictates what page should be changed.
                pointer = (pointer + 1) % capacity; //Pointer moves to next position. % grants to not exceed capacity
                pageFaults++; //PageFaults increase.
            }
        }
        return pageFaults; //Returns the page Faults of Algorithm.
    }
}
