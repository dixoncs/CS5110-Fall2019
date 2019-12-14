import java.util.ArrayList;
import java.util.Random;

/**
 * Hollow Heap class.
 *
 * This is our attempt to implement the TWO-PARENT HOLLOW HEAP data
 * structure introduced by Hansen, Kaplan, Tarjan, and Zwick.
 * 
 * makeHeap() - return a new, empty heap
 * findMin(h) - return an item of minimum key in heap h, or null if h is empty
 * insert(e,k,h) - return a heap formed from heap h by inserting item e, 
 *                 with key k
 * deleteMin(h) - return a heap formed from non-empty heap h by deleting the
 *                item returned by findMin(h)
 * meld(h1,h2) - return a heap containing all items in item-disjoint heaps h1 and h
 * decreaseLey(e,k,h) - given that e is an item in heap h with key greater than k,
 *                      return a heap formed from h by changing the key of e to k
 * delete(e,h) - return a heap fromed by deleting e, assumed to be in h, from h
 *
 * @author Courtney Dixon
 * @version 12/12/2019
 */
public class HollowHeap {

    private int maxRank;
    private HollowNode minH;
    private int numNodes;
    private ArrayList<HollowNode> A = new ArrayList<HollowNode>();   //full of roots indexed by rank (at most 1/rank)

    /**
     * Constructor - makeHeap().
     */
    public HollowHeap() {
        maxRank = 0;
        minH = null;
        numNodes = 0;
    }

    /**
     * One-arg Constructor.
     * @param hNode HollowNode to make minH
     */
    public HollowHeap(HollowNode hNode) {
        maxRank = 0;
        minH = hNode;
        minH.item.node = hNode;
        numNodes += 1;
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
        u.item = e;
        e.node = u;
        u.child = null;
        u.next = null;
        u.extraParent = null;
        u.key = key;
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
    public HollowHeap meld(HollowHeap g, HollowHeap h) {
        if (g == null) {
            return h;
        }
        if (h == null) {
            return g;
        }
        HollowHeap newHHeap = new HollowHeap(link(g.minH, h.minH));
        newHHeap.numNodes = g.numNodes + h.numNodes;
        return newHHeap;
    }

    /**
     * Returns the element of minimum key in the heap.
     *
     * @param h the heap
     * @return element of minimum key or null if empty
     */
    public Node findMin(HollowHeap h) {
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
     * @return a new heap 
     */
    public HollowHeap insert(Node e, int key, HollowHeap h) {
        HollowNode newNode = makeNode(e, key);
        HollowHeap single = new HollowHeap(newNode);
        return meld(single, h);
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
        if (u == h.minH) {
            u.key = key;
            return h;
        }
        HollowNode v = makeNode(e, key);
        u.item = null;
        if (u.rank > 2) {
            v.rank = u.rank - 2;
        }
        v.child = u;
        u.extraParent = v;
        HollowHeap oneDown = new HollowHeap(link(v, h.minH));
        return oneDown;
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
    public HollowHeap delete(Node e, HollowHeap h) {
        numNodes--;
        getFullRoots(h);
        e.node.item = null;
        e.node = null;
        if (h.minH.item != null) {
            // Non-minimum deletion 
            return h;           
        }
        maxRank = 0;
        HollowNode w = new HollowNode();
        HollowNode v = new HollowNode();
        HollowNode u = new HollowNode();
        
        // While L not empty 
        while (h.minH != null) {
            /*w = h.child;    //w = h.minH.child??
            v = h;          //v = h.minH??
            h = h.next;     //h.minH = h.minH.child.next??*/
            w = h.minH.child;
            v = h.minH;
            h.minH = h.minH.next;
            while (w != null) {
                u = w;
                w = w.next;

                // u is hollow 
                if (u.item == null) {

                    // v is the only parent 
                    if (u.extraParent == null) {

                        // add u to L 
                        u.next = h.minH;       
                        h.minH = u;
                    }
                    else {
                        // u has two parents 
                        if (u.extraParent == v) {
                            // v is the second parent 
                            w = null;       
                        }
                        else {
                            // v is the first parent 
                            u.next = null;      
                        }
                        u.extraParent = null;
                    }
                }
                else {
                    // u is full 
                    getFullRoots(h);
                    doRankedLinks(u);
                }
                destroy(v);
            }
        }
        getFullRoots(h);
        doUnrankedLinks();
        return h;
    }
    
    /**
     * Destroys a HollowNode.
     * @param v HollowNode to destroy
     */
    public void destroy(HollowNode v) {
        v.child = null;
        v.extraParent = null;
        v.item = null;
        v.next = null;
    }

    /**
     * Gets the list of full roots.
     * @param h the HollowHeap to get the full roots of
     */
    public void getFullRoots(HollowHeap h) {
        HollowNode temp = h.minH;
        while (temp != null) {
            if (temp.item != null) {
                A.add(temp);
            }
            temp = temp.next;
        }
    }

    /**
     * Does ranked links.
     * @param u a hollow node maybe?
     */
    public void doRankedLinks(HollowNode u) {
        while (A.get(u.rank) != null) {
            u = link(u, A.get(u.rank));
            A.set(u.rank, null);
            if (u.rank + 1 < A.size()) {
                u.rank = u.rank + 1;
            }
        }
        A.set(u.rank, u);
        if (u.rank > maxRank) {
            maxRank = u.rank;
        }
    }

   /**
     * Does unranked links.
     */
    public void doUnrankedLinks() {
        for (int i = 0; i <= maxRank; i++) {
            if (A.get(i) != null) {
                if (minH == null) {
                    minH = A.get(i);
                }
                else {
                    minH = link(minH, A.get(i));
                }
                A.set(i, null);
            }
        }
    }

    /**
     * Accessor method for the numNodes field.
     * @return numNodes number of nodes in the hollow heap
     */
    public int getNumNodes() {
        return numNodes;
    }

    /**
     * Prints minimum node to output.
     */
    public void displayMin() {
        System.out.printf("The minimum's key is %d\n", minH.key);
        System.out.printf("The minimum's item key is %d\n", minH.item.key);
        System.out.print("\n");
    }

    /**
     * Prints the whole HollowHeap.
     */
    public void printHHeap() {
        //System.out.printf("The key of the root is %d\n", minH.key);
        HollowNode temp = minH.child;
        HollowNode temp2 = minH.child;
        //System.out.printf("The first child of the root is %d\n", temp.key);
        //ystem.out.print("The other children of the root are: ");
        while (temp.next != null) {
            System.out.print(temp.key + " ");
            temp2 = temp;
            //temp = temp.next;
            while (temp2.child != null) {
                System.out.print(temp2.key + " ");
                temp2 = temp2.child;
            }
            temp = temp.next;
            System.out.println();
        }
        while (temp.child != null) {
            System.out.print(temp.key + " ");
            temp = temp.child;
        }
        System.out.print(temp.key);
        System.out.println();
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

