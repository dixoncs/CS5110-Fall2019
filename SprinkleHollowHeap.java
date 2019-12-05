public class SprinkleHollowHeap
{
    private SprinkleHollowNode minH;

    public SprinkleHollowHeap()
    {
        minH = null;
        nodeCount = 0;
    }

    public SprinkleHollowNode makeNode(SprinkleHollowNode e, int k)
    {
        SprinkleHollowNode u = new SprinkleHollowNode();
        //All other values are set in the no arg constructor
        u.item = e;
        e.node = u;
        u.key = k;
        return u;
    }

    public SprinkleHollowNode link(SprinkleHollowNode v, SprinkleHollowNode w)
    {
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

    public void addChild(SprinkleHollowNode v, SprinkleHollowNode w)
    {
        v.next = w.child;
        w.child = v;
    }

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

    public SprinkleHollowNode insert(SprinkleHollowNode e, int k)
    {
        return meld(makeNode(e, k));
    }

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

    public void destroy(SprinkleHollowNode u)
    {
        u.child = null;
        u.extraParent = null;
        u.item = null;
        u.key = -1; // destroy key is 1
        u.rank = -1;
    }

    public void doRankedLinks(SprinkleHollowNode u)
    {

    }

    public void doUnrankedLinks()
    {

    }

}