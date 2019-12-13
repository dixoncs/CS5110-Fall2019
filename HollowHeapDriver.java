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
        
        Node e1 = new Node(7);
        Node e2 = new Node();
        Node e3 = new Node();
        Node e4 = new Node();
        Node e5 = new Node();
        Node e6 = new Node();
        HollowHeap test = new HollowHeap(e1);
        test = test.insert(e2, 8, test);
        System.out.println("------------------------------------------------------------");
        System.out.println("HEAP AFTER INSERTING KEY OF 7 AND KEY OF 8");
        test.printHHeap();
        test = test.insert(e3, 6, test);
        System.out.println("------------------------------------------------------------");
        System.out.println("HEAP AFTER INSERTING KEY OF 6");
        test.printHHeap();
        test = test.insert(e4, 9, test);
        System.out.println("------------------------------------------------------------");
        System.out.println("HEAP AFTER INSERTING KEY OF 9");
        test.printHHeap();
        



        /*System.out.println("----------------------------------------------");
        //System.out.println("");
        HollowHeap testHH = new HollowHeap(new HollowNode(4));
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 5, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 8, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(new Node(), 6, testHH);
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
            //System.out.print(nextOne + " ");
            testHH = testHH.insert(new Node(), nextOne, testHH);
            count++;
        }
        Node oneToDelete = new Node(3);
        testHH.insert(oneToDelete, 3, testHH);
        testHH.printHHeap();
        testHH.deleteMin(testHH);
        testHH.printHHeap();
        System.out.println("\n----------------------------------------------");
        System.out.printf("There should be %d HollowNode(s) in the heap"
                        + " and there is(are) %d\n", count, testHH.getNumNodes());
        System.out.println("----------------------------------------------");
        Node currMin = testHH.findMin(testHH);
        System.out.printf("The current minimum is %d\n", currMin.key);
        System.out.println("----------------------------------------------");*/


    }
}

