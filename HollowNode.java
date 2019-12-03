import java.util.*;

/**
 * Hollow Node class.
 *
 * @author Courtney Dixon
 * @version 11/9/2019
 */
public class  HollowNode {
    
    private int key;
    private int rank;
    //private <DATA TYPE> item;     ??? not sure about this one yet maybe a HollowNode as well
    private HollowNode ep;
    private HollowNode child;
    private HollowNode next;
    private HollowNode node;    
    
    /**
     * No-arg Constructor.
     */
    public HollowNode() {
        return new HollowNode();
    } 

}
