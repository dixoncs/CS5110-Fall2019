/**
 * SprinkleHollowHeapClass
 * Follows the implementation on page 15-17 in the paper
 * @author Alisha Sprinkle 
 */
public class SprinkleHollowHeap
{
    private SprinkleHollowNode minH;

     /**
     * Constructor.
     * Sets the min to null and the initial count to 0
     */    
    public SprinkleHollowHeap()
    {
        minH = null;
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
    public SprinkleHollowNode meld(SprinkleHollowNode g)
    {
        if(g == null)
        {
            return minH;
        }
        if(minH == null)
        {
            return g;
        }
        return link(g, minH);
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
    public SprinkleHollowNode insert(SprinkleHollowNode e, int k)
    {
        return meld(makeNode(e, k));
    }

    
    /** 
     * @param e the node we want to decrease the key of
     * @param k the key we want to decrease to
     * @return SprinkleHollowNode
     */
    public SprinkleHollowNode decreaseKey(SprinkleHollowNode e, int k)
    {
        SprinkleHollowNode u = e.node;
        if(u == minH)
        {
            u.key = k;
            return minH;
        }
        SprinkleHollowNode v = makeNode(e,k);
        u.item = null;
        if(u.rank > 2)
        {
            v.rank = u.rank - 2;
        }
        u.child = u;
        u.extraParent = v;
        return link(v,minH);
    }

    
    /** 
     * Deletes a node from the heap
     * @param e the node we want to delete
     * @return SprinkleHollowNode
     */
    public SprinkleHollowNode delete(SprinkleHollowNode e)
    {
        e.node.item = null;
        e.node = null;
        if(minH.item != null)
        {
            return minH;
        }
        maxRank = 0;
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
                    //do ranked stuff
                }
                destroy(u);
            }
            //do unranked stuff
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

    
    /** 
     * @param u
     */
    public void doRankedLinks(SprinkleHollowNode u)
    {

    }

    public void doUnrankedLinks()
    {

    }

}