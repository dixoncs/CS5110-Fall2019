/**
 * FibonacciNode class.
 *
 * @author Alisha Sprinkle (primarily)
 * @author Courtney Dixon (checkstyle)
 * @version 11/9/2019
 */
public class FibonacciNode {
    FibonacciNode parent;
    FibonacciNode child;
    FibonacciNode left;
    FibonacciNode right;
    int key;
    int degree;
    boolean marked;

    /**
     * No-arg Constructor.
     * Sets all values to null.
     * Initially a node will be marked as false
     */
    public FibonacciNode() {
        parent = null;
        child = null;
        left = null;
        right = null;
        key = 0;
        degree = 0;
        marked = false;
    }

    /**
     * One-arg Constructor.
     * Helps in cases where we need to create a new node with specific key
     * @param key FibonacciNodes key
     */
    public FibonacciNode(int key) {
        parent = this;
        child = this;
        left = this;
        right = this;
        this.degree = 0;
        this.key = key;
        this.marked = false;
    }

    /**
     * Seven-arg Constructor.
     * Helps if we need to create a node with all values
     * @param parent FibonacciNode's parent
     * @param child FibonacciNode's child
     * @param left FibonacciNode to FibonacciNode's left
     * @param right FibonacciNode to FibonacciNode's right
     * @param key FibonacciNode's key
     * @param degree FibonacciNode's degree
     * @param marked FibonacciNode's mark
     * 
     */
    public FibonacciNode(FibonacciNode parent, FibonacciNode child, FibonacciNode left, FibonacciNode right,
        int key, int degree, boolean marked) {
        this.parent = parent;
        this.child = child;
        this.left = left;
        this.right = right;
        this.key = key;
        this.degree = degree;
        this.marked = marked;
    }

    /**
     * Accessor method for key field.
     * @return key key field
     */
    public int getKey() {
        return this.key;
    }
}
