public class Main {
    public static void main(String[] args) {

        // Variables
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3};
        int capacity = 3;

        // Classes initialization
        Fifo fifo = new Fifo();
        Lru lru = new Lru();
        Clock clock = new Clock();
        Aging aging = new Aging();

        // Execute methods
        int fifoFaults = fifo.execute(pages, capacity);
        int lruFaults = lru.execute(pages, capacity);
        int clockFaults = clock.execute(pages, capacity);
        int agingFaults = aging.execute(pages, capacity);

        // Prints
        System.out.println("FIFO   - " + fifoFaults + " page faults");
        System.out.println("LRU    - " + lruFaults + " page faults");
        System.out.println("CLOCK  - " + clockFaults + " page faults");
        System.out.println("Aging  - " + agingFaults + " page faults");
    }
}
