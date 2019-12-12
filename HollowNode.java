import java.util.*;

/**
 * Hollow Node class.
 *
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class  HollowNode {
    
    int key;
    int rank;
    Node item;
    HollowNode ep;
    HollowNode child;
    HollowNode next;
    HollowNode node;    
    
    /**
     * No-arg Constructor.
     */
    public HollowNode() {
        HollowNode hugh = new HollowNode();
    } 

}
