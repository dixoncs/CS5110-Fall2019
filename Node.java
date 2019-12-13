/**
 * Node class for the items that are held 
 * by HollowNodes. Called "e" in the paper.
 * 
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class Node {
    int key;
    HollowNode node;    //this is the HollowNode that this node belongs to

    /**
     * No-arg Constructor.
     */
    public Node() {
        key = -1;
        node = null;
    }

    /**
     * One-arg Constructor.
     * @param key nodes key
     */
    public Node(int key) {
        this.key = key;
        node = null;
    }

    /**
     * Two-arg Constructor.
     *
     * @param key node's key
     * @param node node's owner
     */
    public Node(int key, HollowNode node) {
        this.key = key;
        this.node = node;
    }
}

