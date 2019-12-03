public class Node{
    Node parent;
    Node child;
    Node left;
    Node right;
    int key;
    int degree;
    boolean marked;

    public Node()
    {
        parent = null;
        child= null;
        left = null;
        right = null;
        key = 0;
        degree = 0;
        marked = false;
    }
    public Node(int key)
    {
        parent = this;
        child= this;
        left = this;
        right = this;
        this.degree = 0;
        this.key = key;
        this.marked = false;
    }
    public Node(Node parent, Node child, Node left, Node right,
        int key, int degree, boolean marked)
    {
        this.parent = parent;
        this.child = child;
        this.left = left;
        this.right = right;
        this.key = key;
        this.degree = degree;
        this.marked = marked;
    }

    public int getKey()
    {
        return this.key;
    }

    public int getValue()
    {
        return this.value;
    }


}