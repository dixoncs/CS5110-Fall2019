/**
 * Hollow Heap class.
 *
 * This is our attempt to implement the TWO-PARENT HOLLOW HEAP data
 * structure introduced by Hansen, Kaplan, Tarjan, and Zwick.
 * @author Alisha Sprinkle
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class HollowHeap {

    private int maxRank;
    private HollowNode minH;

    /**
     * Constructor - makes an empty heap.
     */
    public HollowHeap() {
        //System.out.println("Hello, Hollow Heap!");
        maxRank = 0;
        minH = new HollowNode();
    }
    
    /**
     * Makes a new node.
     *      an "auxiliary method" 
     * 
     * @param e the node to create
     * @param key the key to set it to
     * @return newHollowNode
     */
    public HollowNode makeNode(Node e, int key) {
        HollowNode u = new HollowNode();
        //e = new Node(k);
        u.item = e;
        e.node = u;
        u.child = null;
        u.next = null;
        u.extraParent = null;
        u.key = k;
        u.rank = 0;
        return u;
    }
    
    /**
     * Link takes in two HollowNodes and
     * determines which is the parent and 
     * which is the child. The child is the
     * "loser" and the parent is the "winner"
     * completely based on key values.
     *      an "auxiliary method" 
     *
     * @param v the first node to link
     * @param w the second node to link
     * @return the HollowNode winner 
     */
    public HollowNode link(HollowNode v, HollowNode w) {
        //if v has a larger key, then it becomes the child of w
        if (v.key >= w.key) {
            addChild(v, w);
            return w;
        }
        //otherwise w has a larger key and it becomes the child of v
        else {
            addChild(w, v);
            return v;
        }
    }
    
    /**
     * Adds a child to the hollow heap.
     *      an "auxiliary method" 
     * 
     * @param v the node to make the child
     * @param w the node to make the parent
     */
    public void addChild(HollowNode v, HollowNode w) {
        v.next = w.child;
        w.child = v;
    }
    
    /**
     * Melds two HollowHeaps together.
     *
     * @param g one-node HollowHeap
     * @param h the main HollowHeap
     * @return link
     */
    public HollowHeap meld(HollowNode g, HollowHeap h) {
        if (g == null) {
            return h;
        }
        if (h == null) {
            return g;
        }
        return link(g, h);
    }
    
    /**
     * Finds the minimum element in the heap.
     *
     * @param h the minimum node in the heap
     * @return item the Node that is held by the minimum 
     */
    public int findMin(HollowHeap h) {
        if (h == null) {
            return null;
        }
        else {
            return h.minH.item;
        }
    }
     
    /**
     * Inserts into the hollow heap.
     *
     * @param e the node to insert
     * @param key the key of the new node to insert
     * @param h the heap
     * @return the top of the heap after adding a new HollowNode
     */
    public HollowNode insert(Node e, int key, HollowHeap h) {
        return meld(makeNode(e, key), h);
    }

    /**
     * Decreases the key of an element in the hollow heap.
     *
     * @param e the node we want to decrease the key of
     * @param key the key we want to decrease to
     * @param h the heap
     * @return a heap formed from h by changing the key of e to k
     */
    public HollowHeap decreaseKey(Node e, int key, HollowHeap h) {
        HollowNode u = e.node;
        if (u == h) {
            u.key = k;
            return h;
        }
        v = makeNode(e, k);
        u.item = null;
        if (u.rank > 2) {
            v.rank = u.rank - 2;
        }
        v.child = u;
        u.extraParent = v;
        return link(v, h.minH);
    }

    /**
     * Deletes the minimum element in the hollow heap.
     *
     * @param h a thing
     * @return a heap formed from non-empty heap h by 
                deleting the item returned by findMin(h)
     */
    public HollowHeap deleteMin(HollowHeap h) {
        return delete(minH.item, h);
    }

    /**
     * Deletes element from the hollow heap.
     *
     * @param e a thing
     * @param h a thing
     * @return h a thing
     */
    public HollowHeap delete(HollowNode e, HollowHeap h) {
        e.node.item = null;
        e.node = null;
        if (minH.item != null) {
            // Non-minimum deletion 
            return h;           
        }
        maxRank = 0;

        // While L not empty 
        while (h != null) {
            w = h.child;
            v = h;
            h = h.next;
            while (w != null) {
                u = w;
                w = w.next;

                // u is hollow 
                if (u.item = null) {

                    // v is the only parent 
                    if (u.ep = null) {

                        // add u to L 
                        u.next = h;       
                        h = u;
                    }
                    else {
                        // u has two parents 
                        if (u.ep = v) {
                            // v is the second parent 
                            w = null;       
                        }
                        else {
                            // v is the first parent 
                            u.next = null;      
                        }
                        u.ep = null;
                    }
                }
                else {
                    // u is full 
                    doRankedLinks();
                }
                destroy v;
            }
        }
        doUnrankedLinks();
        return h;
    }

    /**
     * Does ranked links.
     * @param u a hollow node maybe?
     */
    public void doRankedLinks(HollowNode u) {
        while (A[u.rank] != null) {
            u = link(u, A[u.rank]);
            A[u.rank] = null;
            u.rank = u.rank + 1;
        }
        A[u.rank] = u;
        if (u.rank > maxRank) {
            maxRank = u.rank;
        }
    }

    /**
     * Does unranked links.
     */
    public void doUnrankedLinks() {
        for (int i = 0; i < maxRank; i++) {
            if (A[i] != null) {
                if (h = null) {
                    h = A[i];
                }
                else {
                    h = link(h, A[i]);
                }
                A[i] = null;
            }
        }
    }

    /**
     * Main method.
     *
     * @param args command-line arguments
     *
    public static void main(String[] args) {
        HollowHeap testHollowHeap = new HollowHeap();
    }*/
}

