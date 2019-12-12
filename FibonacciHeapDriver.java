//import java.util.*;

/**
 * Fibonacci Heap driver class.
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class FibonacciHeapDriver {
    
    /**
     * Main method.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        FibonacciHeap fh = new FibonacciHeap();
        
        System.out.println("Running test 1");
        FibonacciNode n1 = new FibonacciNode(6);
        FibonacciNode n2 = new FibonacciNode(4);
        FibonacciNode n3 = new FibonacciNode(8);
        fh.insert(n1);
        fh.insert(n2);
        fh.insert(n3);

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing insert. Heap should contain 4,6,8");
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Decreasing key of n2 (4) to 3");
        fh.decreaseKey(n2, 3);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println(("Testing find min. Should return 3"));
        System.out.println(fh.findMin().key);
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete min. Heap should contain 6,8");
        fh.deleteMin();
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");
        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 6. Heap should contain 8");
        fh.delete(n1);
        System.out.println("The new min should be 8. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 8. Heap should contain nothing.");
        fh.delete(n3);
        System.out.println("The new min should be null. Min is: " + fh.findMin());
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");
        
        System.out.println("Running test 2");
        FibonacciNode n4 = new FibonacciNode(6);
        FibonacciNode n5 = new FibonacciNode(4);
        FibonacciNode n6 = new FibonacciNode(8);
        fh.insert(n4);
        fh.insert(n5);
        fh.insert(n6);

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing insert. Heap should contain 4,6,8");
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Decreasing key of n4 (4) to 3");
        fh.decreaseKey(n4, 3);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println(("Testing find min. Should return 3"));
        System.out.println(fh.findMin().key);
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete min. Heap should contain 6,8");
        fh.deleteMin();
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 8. Heap should contain 6");
        fh.delete(n6);
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 6. Heap should contain nothing.");
        fh.delete(n5);
        System.out.println("The new min should be null. Min is: " + fh.findMin());
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");


    }
}
