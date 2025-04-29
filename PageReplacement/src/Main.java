public class Main {
    public static void main(String[] args) {

        //Variables
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3};
        int capacity = 3;

        //Classes initialization
        Fifo fifo = new Fifo();


        //execute methods
        int fifoFaults = fifo.execute(pages, capacity);


        //Prints
        System.out.println("Método FIFO - " + fifoFaults + " faltas de página");

    }
}
