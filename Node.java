public class Node{
    Node parent;
    Node child;
    Node left;
    Node right;
    int key;
    int degree;

    public Node()
    {
        parent = null;
        child= null;
        left = null;
        right = null;
        key = 0;
        degree = 0;
    }
    public Node(Node parent, Node child, Node left, Node right, int key, int degree)
    {
        this.parent = parent;
        this.child = child;
        this.left = left;
        this.right = right;
        this.key = key;
        this.degree = degree;
    }

}