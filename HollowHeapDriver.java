import java.util.Random;

/**
 * Hollow Heap driver class.
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class HollowHeapDriver {

    private static Random rando;

    /**
     * Main method.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        int nextOne = 0;
        rando = new Random();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        HollowHeap testHH = new HollowHeap(new HollowNode(3));
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 2, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 1, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 0, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 7, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        testHH.printHHeap();
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 20; i++) {
            nextOne = rando.nextInt(25);
            System.out.print(nextOne + " ");
            testHH = testHH.insert(new Node(), nextOne, testHH);
            count++;
        }
        //testHH.printHHeap();
        System.out.println("\n----------------------------------------------");
        System.out.printf("There should be %d HollowNode(s) in the heap"
                        + " and there is(are) %d\n", count, testHH.getNumNodes());
        System.out.println("----------------------------------------------");
        Node currMin = testHH.findMin(testHH);
        System.out.printf("The current minimum is %d\n", currMin.key);
        System.out.println("----------------------------------------------");


    }
}

