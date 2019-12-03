/**
 * Node class.
 *
 * @author Alisha Sprinkle (primarily)
 * @author Courtney Dixon (checkstyle)
 * @version 11/9/2019
 */
public class Node {
    Node parent;
    Node child;
    Node left;
    Node right;
    int key;
    int degree;
    boolean marked;

    /**
     * No-arg Constructor.
     */
    public Node() {
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
     * @param key nodes key
     */
    public Node(int key) {
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
     * @param parent node's parent
     * @param child node's child
     * @param left node to node's left
     * @param right node to node's right
     * @param key node's key
     * @param degree node's degree
     * @param marked node's marked fam 
     */
    public Node(Node parent, Node child, Node left, Node right,
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

    /**
     * Accessor method for value.
     * ?? THIS IS NOT A FIELD HERE ??
     * @return value not sure???
     */
    public int getValue() {
        return this.value;
    }
}
