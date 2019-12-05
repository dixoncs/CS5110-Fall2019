public class SprinkleHollowNode
{
    SprinkleHollowNode item;
    SprinkleHollowNode node;
    SprinkleHollowNode child;
    SprinkleHollowNode next;
    SprinkleHollowNode extraParent;
    int key;
    int rank;

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
}