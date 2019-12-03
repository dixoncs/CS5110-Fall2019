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
public class HollowHeap
{
    private int maxRank;
    
    /**
     * Constructor.
     */
    public HollowHeap()
    {
        System.out.println("Hello, Hollow Heap!");
        maxRank = 0;
    }

    /**
     * Makes a heap.
     *
     * @return null
     */
    public HollowHeap makeHeap()
    {
        return null;
    }

    /**
     * Inserts into the hollow heap.
     *
     * @return meld
     */
    public HollowHeap insert( e, k, h)
    {
        return meld(make_node(e, K), h);
    }

    /**
     * Melds hollow heaps g and h.
     *
     * @return link
     */
    public HollowHeap meld(HollowHeap g, HollowHeap h)
    {
        if (g == null)
        {
            return h;
        }
        if (h == null)
        {
            return g;
        }
        return link(g, h);
    } 

    /**
     * Finds the minimum element in the hollow heap.
     *
     * @return item
     */
    public String findMin(h)
    {
        if (h == null)
        {
            return null;
        }
        else
        {
            return h.item;
        }
    }

    /**
     * Decreases the key of an element in the hollow heap.
     *
     * @return link
     */
    public HollowHeap decreaseKey(e, k, h)
    {
        u = e.node;
        if (u == h)
        {
            u.key = k;
            return h;
        }
        v = makeNode(e, k);
        u.item = null;
        if (u.rank > 2)
        {
            v.rank = u.rank - 2;
        }
        v.child = u;
        u.ep = v;
        return link(v, h)
    }

    /**
     * Deletes the minimum element in the hollow heap.
     *
     * @return delete
     */
    public HollowHeap deleteMin(h)
    {
        return delete(h.item, h);
    }

    /**
     * Deletes element from the hollow heap.
     */
    public HollowHeap delete(e, h)
    {
        e.node.item = null;
        e.node = null;
        if (h.item != null)
        {
            return h;           /* Non-minimum deletion */
        }
        maxRank = 0;
        while (h != null)       /* While L not empty */
        {
            w = h.child;
            v = h;
            h = h.next;
            while (w != null)
            {
                u = w;
                w = w.next;
                if (u.item = null)        /* u is hollow */
                {
                    if (u.ep = null)      /* v is the only parent */
                    {
                        u.next = h;       /* add u to L */
                        h = u;
                    }
                }
                else        /* u has two parents */
                {
                    if (u.ep = v)
                    {
                        w = null;       /* v is the second parent */
                    }
                    else
                    {
                        u.next = null;      /* v is the first parent */
                    }
                    u.ep = null;
                }
            }
            else        /* u is full */
            {
                doRankedLinks();
            }
            destroy v;
        }
        doUnrankedLinks();
        return h;
    }

    /**
     * Does ranked links.
     */
    public void doRankedLinks(u)
    {
        while (A[u.rank] != null)
        {
            u = link(u, A[u.rank]);
            A[u.rank] = null;
            u.rank = u.rank + 1;
        }
        A[u.rank] = u;
        if (u.rank > maxRank)
        {
            maxRank = u.rank;
        }
    }

    /**
     * Does unranked links.
     */
    public void doUnrankedLinks()
    {
        for (int i = 0; i < maxRank; i++)
        {
            if (A[i] != null)
            {
                if (h = null)
                {
                    h = A[i];
                }
                else
                {
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
    public makeNode(e, k)
    {
        u = newNode();
        u.item = e;
        e.node = u;
        u.child = null;
        u.next = nulll;
        u.ep = null;
        u.key = k;
        u.rank = 0;
        return u
    }

    /**
     * Links things in a hollow heap.
     *      an "auxiliary method" 
     * @return w
     */
    public HollowHeap link(v, w)
    {
        if (v.key >= w.key)
        {
            addChild(v, w);
            return w;
        }
        else
        {
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
    public addChild(v, w)
    {
        v.next = w.child;
        w.child = v;
    }

    /**
     * Main method.
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
         HollowHeap testHollowHeap = new HollowHeap();
    }
}

