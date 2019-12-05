/**
 * Sprinkle Hollow Node class.
 * @author Alisha Sprinkle (primarily)
 * @version 12/5/2019
 */
public class SprinkleHollowNode
{
    SprinkleHollowNode item;
    SprinkleHollowNode node;
    SprinkleHollowNode child;
    SprinkleHollowNode next;
    SprinkleHollowNode extraParent;
    int key;
    int rank;

     /**
     * No-arg Constructor
     * Sets everything to null and 0
     */
    public SprinkleHollowNode()
    {
        item = null;
        node = null;
        child = null;
        next = null;
        extraParent = null;
        key = 0;
        rank = 0;
    }
    /**
     * Arg Construtor
     * Useful if we need to make predefined nodes 
     * @param item
     * @param node
     * @param child
     * @param next
     * @param extraParent
     * @param key
     * @param rank
     */
    public SprinkleHollowNode(SprinkleHollowNode item, SprinkleHollowNode node, 
        SprinkleHollowNode child, SprinkleHollowNode next, SprinkleHollowNode extraParent,
        int key, int rank)
    {
         this.item = item;
         this.node = node;
         this.child = child;
         this.next = next;
         this.key = key;
         this.rank = rank;
    }
}