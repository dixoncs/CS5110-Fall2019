import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

/**
 * SprinkleHollowHeapClass
 * Follows the implementation on page 15-17 in the paper
 * @author Alisha Sprinkle 
 */
public class SprinkleHollowHeap
{
    private SprinkleHollowNode minH;
    ArrayList<SprinkleHollowNode> A = new ArrayList<SprinkleHollowNode>();
    int maxRank = 0;
    int nodeCount;

     /**
     * Constructor.
     * Sets the min to null and the initial count to 0
     */    
    public SprinkleHollowHeap()
    {
        minH = null;
        nodeCount = 0;
    }
    
    /** 
     * @param e The node to create
     * @param k the key to set it to
     * @return SprinkleHollowNode
     */    
    public SprinkleHollowNode makeNode(SprinkleHollowNode e, int k)
    {
        SprinkleHollowNode u = new SprinkleHollowNode();
        //All other values are set in the no arg constructor
        u.item = e;
        e.node = u;
        u.key = k;
        return u;
    }

    
    /** 
     * @param v the first node to link
     * @param w the second node to link
     * @return SprinkleHollowNode
     */
    public SprinkleHollowNode link(SprinkleHollowNode v, SprinkleHollowNode w)
    {
        //we want the child to be the larger of the two nodes linking
        if(v.key >= w.key)
        {
            addChild(v,w);
            return w;
        }
        else
        {
            addChild(w,v);
            return v;
        }
    }

    
    /** 
     * @param v the node to make the child
     * @param w the node to make the parent
     */
    public void addChild(SprinkleHollowNode v, SprinkleHollowNode w)
    {
        v.next = w.child;
        w.child = v;
    }

    
    /** 
     * @param g merges two nodes/heaps together
     * @return SprinkleHollowNode
     */
    public void meld(SprinkleHollowNode g, SprinkleHollowNode h)
    {
        if(g == null)
        {
           minH = h;
        }
        else if(h == null)
        {
            minh = g;
        }
        else
        {
            minH = link(g, h);
        }
    }

    
    /** 
     * @return SprinkleHollowNode the min node 
     */
    public SprinkleHollowNode findMin()
    {
        if(minH == null)
        {
            return null;
        }
        else
        {
            return h.item;
        }
    }

    
    /** 
     * @param e the node to insert
     * @param k the key of the new node to insert
     * @return SprinkleHollowNode
     */
    public void insert(SprinkleHollowNode e, int k)
    {
        nodeCount++;
        meld(makeNode(e, k), minH);
    }

    
    /** 
     * @param e the node we want to decrease the key of
     * @param k the key we want to decrease to
     * @return SprinkleHollowNode
     */
    public void decreaseKey(SprinkleHollowNode e, int k)
    {
        SprinkleHollowNode u = e.node;
        if(u == minH)
        {
            u.key = k;
        }
        else
        {
            SprinkleHollowNode v = makeNode(e,k);
            u.item = null;
            if(u.rank > 2)
            {
                v.rank = u.rank - 2;
            }
            u.child = u;
            u.extraParent = v;
            link(v,minH);
        }
    }

    public SprinkleHollowNode deleteMin()
    {
        return delete(minH);
    }
    
    /** 
     * Deletes a node from the heap
     * @param e the node we want to delete
     * @return SprinkleHollowNode
     */
    public SprinkleHollowNode delete(SprinkleHollowNode e)
    {
        nodeCount--;
        e.node.item = null;
        e.node = null;
        if(minH.item != null)
        {
            return minH;
        }
        maxRank = 0;
        getFullRoots();
        while(h != null)
        {
            SprinkleHollowNode w = minH.child;
            SprinkleHollowNode v = minH;
            minH = minH.next;
            while(w != null)
            {
                SprinkleHollowNode u = w;
                w = w.next;
                if(u.item = null)
                {
                    if(u.extraParent = null)
                    {
                        u.next = minH;
                        minH = u;
                    }
                    else
                    {
                        if(u.extraParent = v)
                        {
                            w = null;
                        }
                        else
                        {
                            u.next = null;
                            u.extraParent = null;
                        }
                    }
                }
                else{
                    doRankedLinks(u);
                }
                destroy(u);
            }
            doUnrankedLinks();
        }
    }

    /** 
     * Destroys the node by setting everything to null.
     * @param u the node to be set to null
     */
    public void destroy(SprinkleHollowNode u)
    {
        u.node = null;
        u.child = null;
        u.extraParent = null;
        u.item = null;
        u.key = -1; // destroy key is -1
        u.rank = -1;
    }

    public void getFullRoots()
    {
        SprinkleHollowNode temp = minH;
        while(temp != null)
        {
            if(temp.item != null)
            {
                A.add(temp);
            }
            temp = temp.next;
        }
    }

    /** 
     * @param u
     */
    public void doRankedLinks(SprinkleHollowNode u)
    {
        while(A.get(u.rank) != null)
        { 
            u = link(u, A.get(u.rank));
            A.set(u.rank,null);
            u.rank = u.rank + 1; 
        }
        A.set(u.rank,u);
        if(u.rank > maxRank)
        {
            maxRank = u.rank;
        }
    }

    public void doUnrankedLinks()
    {
        for(int i = 0; i < maxRank; i++)
        {
            if(A.get(i) != null)
            {
                if(minH = null)
                {
                    minH = A.get(i);
                }
                else
                {
                    minH = link(minH, A.get(i));
                }
                A.set(i,null);
            }
        }
    }
      /**
     * DisplayHeap prints out a string representation of the heap.
     * Useful for checking tests.
     */
    public void displayHeap() {
        SprinkleHollowNode pointer = minH;
        String tree = "";
        if (pointer == null) {
            tree += "Heap is Empty";
        } 
        else {
            do {
                tree += pointer.key;
                pointer = pointer.next;
                if (pointer != minH) {
                    tree += "->";
                }
            } 
            while (pointer != minH && pointer.next != null);
            tree += "\n" + "The heap has " + nodeCount + " nodes.";
        }
        System.out.println(tree);
    }

    public void test2(SprinkleHollowHeap sh) {
        System.out.println("Running test 2");
        SprinkleHollowNode n1 = new SprinkleHollowNode();
        SprinkleHollowNode n2 = new SprinkleHollowNode();
        SprinkleHollowNode n3 = new SprinkleHollowNode();
        sh.insert(n1, 6);
        sh.insert(n2, 4);
        sh.insert(n3, 8);
          
        System.out.println("-----------------------------------------------------");
        System.out.println("Testing insert. Heap should contain 4,6,8");
        sh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Decreasing key of n2 (4) to 3");
        sh.decreaseKey(n2, 3);
        sh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println(("Testing find min. Should return 3"));
        System.out.println(sh.findMin().key);
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete min. Heap should contain 6,8");
        sh.deleteMin();
        System.out.println("The new min should be 6. Min is: " + sh.findMin().key);
        sh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 8. Heap should contain 6");
        sh.delete(n3);
        System.out.println("The new min should be 6. Min is: " + sh.findMin().key);
        sh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 6. Heap should contain nothing.");
        sh.delete(n2);
        System.out.println("The new min should be null. Min is: " + sh.findMin());
        sh.displayHeap();
        System.out.println("-----------------------------------------------------\n");
    }

    public static void main(String[] args)
    {
        SprinkleHollowHeap sh = new SprinkleHollowHeap();
        sh.test2(sh);
    }
}