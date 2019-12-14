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
        Node e2 = new Node(2);
        HollowHeap testHH = new HollowHeap(new HollowNode(3));
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        testHH = testHH.insert(e2, e2.key, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        Node e3 = new Node(1);
        testHH = testHH.insert(e3, e3.key, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        Node e4 = new Node(0);
        testHH = testHH.insert(e4, e4.key, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        //System.out.println("");
        Node delNode = new Node(7);
        testHH = testHH.insert(delNode, delNode.key, testHH);
        count++;
        testHH.displayMin();
        System.out.println("----------------------------------------------");
        testHH.printHHeap();
        System.out.println("----------------------------------------------");
        /*for (int i = 0; i < 20; i++) {
            nextOne = rando.nextInt(25);
            System.out.print(nextOne + " ");
            testHH = testHH.insert(new Node(), nextOne, testHH);
            count++;
        }*/
        //testHH.printHHeap();
        System.out.println("\n----------------------------------------------");
        System.out.printf("There should be %d HollowNode(s) in the heap"
                        + " and there is(are) %d\n", count, testHH.getNumNodes());
        System.out.println("----------------------------------------------");
        Node currMin = testHH.findMin(testHH);
        System.out.printf("The current minimum is %d\n", currMin.key);
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.printf("There should be %d HollowNode(s) in the heap"
        + " and there is(are) %d\n", count, testHH.getNumNodes());
        testHH = testHH.delete(delNode, testHH);
        count--;
        System.out.printf("There should be %d HollowNode(s) in the heap"
        + " and there is(are) %d\n", count, testHH.getNumNodes());
        testHH = testHH.deleteMin(testHH);
        count--;
        System.out.printf("There should be %d HollowNode(s) in the heap"
        + " and there is(are) %d\n", count, testHH.getNumNodes());
        System.out.println("----------------------------------------------");
        testHH.printHHeap();
        testHH = testHH.decreaseKey(e2, 1, testHH);
        System.out.println(e2.key);
    }
}

