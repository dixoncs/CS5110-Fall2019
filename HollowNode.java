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
    HollowNode child;
    HollowNode next;
    HollowNode extraParent;
    
    /**
     * No-arg Constructor.
     */
    public HollowNode() {
        key = 0;
        rank = 0;
        item = new Node();
        child = null;
        next = null;
        extraParent = null;
    } 
}
