/**
 * Node class.
 *
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class Node {
    int key;
    Node n;

    /**
     * No-arg Constructor.
     */
    public Node() {
        key = -1;
        
    }

    /**
     * One-arg Constructor.
     * @param key nodes key
     */
    public Node(int key)
        this.key = key;
        n = null;
    }

    /**
     * Two-arg Constructor.
     *
     * @param key node's key
     * @param node node's owner
     */
    public Node(int key, Node node) {
        this.key = key;
        this.n = node;
    }

    /**
     * Accessor method for key field.
     *
     * @return key key field
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Accessor method for n field.
     * 
     * @return n node's owner
     */
    public int getNode() {
        return this.n;
    }
}
