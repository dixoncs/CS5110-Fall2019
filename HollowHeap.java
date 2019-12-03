import java.util.*;

/**
 * Hollow Heap class.
 *
 * This is our attempt to implement the TWO-PARENT HOLLOW HEAP data
 * structure introduced by Hansen, Kaplan, Tarjan, and Zwick.
 * 
 * @authors Courtney Dixon and Alisha Sprinkle
 * @version 11/9/2019
 */
public class HollowHeap {
    
    private int maxRank;
    private HollowNode[] A;
     
    /**
     * Constructor.
     */
    public HollowHeap() {
        System.out.println("Hello, Hollow Heap!");
        maxRank = 0;
        makeHeap();
        A = new HollowNode[];
    }

    /**
     * Makes a heap.
     *
     * @return null
     */
    public HollowHeap makeHeap() {
        return null;
    }

    /**
     * Inserts into the hollow heap.
     *
     * @return meld
     */
    public HollowHeap insert(HollowNode e, int key, HollowHeap h) {
        return meld(makeNode(e, key), h);
    }

    /**
     * Melds hollow heaps g and h.
     *
     * @return link
     */
    public HollowHeap meld(HollowHeap g, HollowHeap h) {
        if (g == null) {
            return h;
        }
        if (h == null) {
            return g;
        }
        return link(g, h);
    } 

    /**
     * Finds the minimum element in the h heap.
     *
     * @return item
     */
    public int findMin(HollowHeap h) {
        if (h == null) {
            return null;
        }
        else {
            return h.item;
        }
    }

    /**
     * Decreases the key of an element in the hollow heap.
     *
     * @return link
     */
    public HollowHeap decreaseKey(HollowNode e, int key, HollowHeap h) {
        u = e.node;
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
        u.ep = v;
        return link(v, h);
    }

    /**
     * Deletes the minimum element in the hollow heap.
     *
     * @return delete
     */
    public HollowHeap deleteMin(HollowHeap h) {
        return delete(h.item, h);
    }

    /**
     * Deletes element from the hollow heap.
     */
    public HollowHeap delete(HollowNode e, HollowHeap h) {
        e.node.item = null;
        e.node = null;
        if (h.item != null) {
            /* Non-minimum deletion */
            return h;           
        }
        maxRank = 0;

        /* While L not empty */
        while (h != null) {
            w = h.child;
            v = h;
            h = h.next;
            while (w != null) {
                u = w;
                w = w.next;

                /* u is hollow */
                if (u.item = null) {

                    /* v is the only parent */
                    if (u.ep = null) {

                        /* add u to L */
                        u.next = h;       
                        h = u;
                    }
                    else {
                        /* u has two parents */
                        if (u.ep = v) {
                            /* v is the second parent */
                            w = null;       
                        }
                        else {
                            /* v is the first parent */
                            u.next = null;      
                        }
                        u.ep = null;
                    }
                }
                else {
                    /* u is full */
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
     * Makes a new node.
     *      an "auxiliary method" 
     * @return newNode
     */
    public HollowNode makeNode(HollowNode e, int key) {
        u = new HollowNode();
        u.item = e;
        e.node = u;
        u.child = null;
        u.next = null;
        u.ep = null;
        u.key = k;
        u.rank = 0;
        return u;
    }

    /**
     * Links things in a hollow heap.
     *      an "auxiliary method" 
     * @return w
     */
    public HollowNode link(HollowNode v, HollowNode w) {
        if (v.key >= w.key) {
            addChild(v, w);
            return w;
        }
        else {
            addChild(w, v);
            return v;
        }
    }

    /**
     * Adds a child to the hollow heap.
     *      an "auxiliary method" 
     * @param v
     * @param w
     */
    public void addChild(HollowNode v, HollowNode w) {
        v.next = w.child;
        w.child = v;
    }

    /**
     * Main method.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
         HollowHeap testHollowHeap = new HollowHeap();
    }
}

