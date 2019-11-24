import sun.rmi.runtime.NewThreadAction;

//import java.util.*;

/**
 * Fibonacci Heap class.
 * @author Courtney Dixon and Alisha Sprinkle
 * @version 11/9/2019
 */
public class FibonacciHeap
{
    Node min;
    int nodeCount;
    /**
     * Constructor.
     */
    public FibonacciHeap()
    {
        min = null;
        nodeCount = 0;
       
    }

    public void insert(int val)
    {
        Node newNode = new Node();
        newNode.left = newNode;
        newNode.right = newNode;
        newNode.key = val;
        if(min != null)
        {
            (min.left).right = newNode;
            newNode.left = min.left;
            newNode.right = min;
            min.left = newNode;
            if(newNode.key <= min.key)
            {
                min = newNode;
            }
        }
        else{
            min = newNode;
        }
        nodeCount++;
    }
    public void cut(Node found, Node temp)
    {
        if(found == found.right)
        {
            temp.child = null;
        }
        (found.left).right = found.right;
        (found.right).left = found.left;

        if(found == temp.child)
        {
            temp.child = found.right;
        }
        temp.degree = temp.degree - 1;
        found.right = found;
        found.left = found;
        (min.left).right = found;
        found.right = min;
        found.left = min.left;
        min.left = found;
        found.parent = null;
        
    }
    public void decreaseKeyOp(Node found, int key)
    {
        if(min == null)
        {
            System.out.println("Heap is empty");
        }
        if(found == null)
        {
            System.out.println("Node not found");
        }
        found.key = key;
        Node temp = found.parent;
        if(temp != null && found.key < temp2.key)
        {
           cut(found,temp);
        }
        if(found.key < min.key)
        {
            min = found;
        }
    }
    public void decreaseKey(Node min, int oldKey, int newKey)
    {
        Node found = null;
        Node temp = min;
        Node foundPtr = null;
        if(temp.key == oldKey)
        {
            foundPtr = temp;
            found = foundPtr;
            decreaseKeyOp(found, newKey);
        }
        if(foundPtr == null)
        {
            if(temp.child != null)
            {
                decreaseKey(temp.child, oldKey, newKey);
            }
        }
        found = foundPtr;
    }
    public void displayHeap()
    {
        Node pointer = min;
        String tree = "";
        if(pointer == null)
        {
            tree += "Heap is Empty";
        }
        else
        {
            do
            {
                tree += pointer.key;
                pointer = pointer.right;
                if(pointer != min){
                    tree += "->";
                }
            }while(pointer != min && pointer.right != null);
            tree += "\n" + "The heap has " + nodeCount + " nodes.";
        }
        System.out.println(tree);
    }
    public static void main(String[] args)
    {
        System.out.println("Creating Fibonacci Heap");
        FibonacciHeap fh = new FibonacciHeap();
        fh.insert(12);
        fh.insert(4);
        fh.insert(8);
        fh.displayHeap();
        fh.decreaseKey(fh.min,2,1);
        fh.displayHeap();
    }
    
}

