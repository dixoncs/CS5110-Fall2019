import java.util.*;
//import java.lang.Math;

/**
 * Fibonacci Heap class.
 * @author Alisha Sprinkle
 * @version 11/9/2019
 */
public class FibonacciHeap {
    
    private Node minNode;
    private int nodeCount;
    /**
     * Constructor.
     */
    public FibonacciHeap() {
        minNode = null;
        nodeCount = 0;
    }

    /**
     * Insert.
     * @param newNode a thing
     */
    public void insert(Node newNode) {
        // heap is not empty
        if (minNode != null) {
            // Add in the new Node to the right of our min
            newNode.left = minNode;
            newNode.right = minNode.right;
            minNode.right = newNode;

            // newNode right is now the minNodes right
            // it could have already had more right elements
            if (newNode.right != null) {
                // set the right elements left
                newNode.right.left = newNode;
            }
            // it didnt have right elements
            else {
                newNode.right = minNode;
                minNode.left = newNode;
            }
            // Move minNode to the newNode if key is smaller
            if (newNode.key < minNode.key) {
                minNode = newNode;
            }
        } 
        else {
            minNode = newNode;
        }
        nodeCount++;
    }

    /**
     * Cut.
     * @param cutNode a thing
     * @param fromNode a thing
     */
    public void cut(Node cutNode, Node fromNode) {
        // Old technique did not work
        // I forgot to include a marked flag
        // and I was getting confused about who I was cutting
        // variable name change should help

        // remove cutNode fromNode.
        // Decrease the degree of fromNode since node is gone
        cutNode.left.right = cutNode.right;
        cutNode.right.left = cutNode.left;
        fromNode.degree--;

        // We could hae removed the last thing from the fromNode
        // No more children then
        if (fromNode.degree == 0) {
            fromNode.child = null;
        }

        // Could have removed a directchild.
        // Need to move fromNode child to the node to the
        // right of the cutNode
        if (fromNode.child == cutNode) {
            fromNode.child = cutNode.right;
        }

        // cutNode now needs to be in the root list
        // Same as saying attach it to minNode
        cutNode.left = minNode;
        cutNode.right = minNode.right;
        minNode.right = cutNode;
        cutNode.right.left = cutNode;

        // now that cutNode is in the root list it
        // does not have a arent

        cutNode.parent = null;
        cutNode.marked = false;

    }

    /**
     * Cascade Cut.
     * @param cutNode a thing
     */
    public void cascadeCut(Node cutNode) {
        // In my implementation of decreaseKey I was only cutting
        // Cascade cut is used to help keep thet time complexity small
        // Allows you to cut the edge joining a node to a parent
        // the you make the new node a root.
        Node cutNodeParent = cutNode.parent;

        if (cutNodeParent != null) {
            // if the parent is not marked we will mark it
            if (cutNode.marked == false) {
                cutNode.marked = true;
            }
            // if it was marked cut it from the parent
            else {
                cut(cutNode, cutNodeParent);
                // now we need to cut the parent as well
                // hence the cascade
                cascadeCut(cutNodeParent);
            }
        }
    }

    /**
     * Make Child.
     * @param child a thing
     * @param parent a thing
     */
    public void makeChild(Node child, Node parent) {
        // take child out of the root list
        child.left.right = child.right;
        child.right.left = child.left;

        child.parent = parent;

        if (parent.child == null) {
            child.right = child;
            child.left = child;
            parent.child = child;
        } 
        else {
            child.left = parent.child;
            child.right = parent.child.right;
            parent.child.right = child;
            parent.right.left = child;
        }
        child.marked = false;
        // the parent has a new child so degree increases
        parent.degree++;
    }

    /**
     * Decrease Key.
     * @param decNode a thing
     * @param key a thing
     */
    public void decreaseKey(Node decNode,  int key) {
        // set the key
        decNode.key = key;

        Node decNodeParent = decNode.parent;

        if ((decNodeParent != null) && (decNode.key < decNodeParent.key)) {
            cut(decNode, decNodeParent);
            // it isnt enough to only cut the node from the parent
            // parent may have to be cut as well
            cascadeCut(decNodeParent);
        }
        if (decNode.key < minNode.key) {
            minNode = decNode;
        }
    }

    /**
     * Find Minimum.
     * @return minNode a thing
     */
    public Node findMin() {
        return minNode;
    }

    /**
     * Delete Minimum.
     */
    public void deleteMin() {
        Node tempMin = minNode;
        Node tempMinPtr = tempMin;
        Node tempMinChild = null;
        if (tempMin != null) {
            if (tempMin.child != null) {
                tempMinChild = tempMin.child;
                do {
                    tempMinPtr = tempMinChild.right;
                    minNode.left.right = tempMinChild;
                    tempMinChild.right = minNode;
                    tempMinChild.left = minNode.left;
                    minNode.left = tempMinChild;
                    if (tempMinChild.key < minNode.key) {
                        minNode = tempMinChild;
                    }
                    tempMinChild.parent = null;
                    tempMinChild = tempMinPtr;
                } 
                while (tempMinPtr != tempMin.child);
            }
            tempMin.left.right = tempMin.right;
            tempMin.right.left = tempMin.left;
            minNode = tempMin.left;
            if (tempMin == tempMin.right && tempMin.child == null) {
                minNode = null;
            } 
            else {
                minNode = tempMin.left;
                consolidate();
            }
            nodeCount--;
        }   
        if (nodeCount == 0) {
            minNode = null;
        }
    }

    /**
     * Delete.
     * @param dNode a thing
     */
    public void delete(Node dNode) {
        if (dNode == null) {
            System.out.println("Can't delete a null node!");
        }
        if (dNode == minNode) {
            deleteMin();
        }
        else {
            decreaseKey(dNode, -1);
            deleteMin();
        }
    }

    /**
     * Consolidate.
     */
    public void consolidate() {
        int sizeInt = nodeCount + 50;
        List<Node> degreeTable = new ArrayList<Node>(sizeInt);
        for (int i = 0; i < sizeInt; i++) {
            degreeTable.add(null);
        }
        // need the number of roots
        int rootCount = 0;
        Node tempMin = minNode;

        if (tempMin != null) {
            rootCount++;
            tempMin = tempMin.right;
            while (tempMin != minNode) {
                rootCount++;
                tempMin = tempMin.right;
            }
        }
        while (rootCount > 0) {
            int tempMinDegree = tempMin.degree;
            Node tempMinRight = tempMin.right;
            while (true) {
                Node compNode = degreeTable.get(tempMinDegree);
                if (compNode == null) {
                    break;
                }
                if (tempMin.key > compNode.key) {
                    Node temp = compNode;
                    compNode = tempMin;
                    tempMin = temp;
                }
                makeChild(tempMin, compNode);
                degreeTable.set(tempMinDegree, null);
                tempMinDegree++;
            }
            degreeTable.set(tempMinDegree, tempMin);
            tempMin = tempMinRight;
            rootCount--;
        }
        minNode = null;
        for (int i = 0; i < sizeInt; i++) {
            Node cNode = degreeTable.get(i);
            if (cNode == null) {
                continue;
            }
            if (minNode != null) {
                cNode.left.right = cNode.right;
                cNode.right.left = cNode.left;
                cNode.left = minNode;
                cNode.right = minNode.right;
                minNode.right = cNode;
                cNode.right.left = cNode;
                if (cNode.key < minNode.key) {
                    minNode = cNode;
                }
            }
            else {
                minNode = cNode;
            }
        }
    }

    /**
     * DisplayHeap.
     */
    public void displayHeap() {
        Node pointer = minNode;
        String tree = "";
        if (pointer == null) {
            tree += "Heap is Empty";
        } 
        else {
            do {
                tree += pointer.key;
                pointer = pointer.right;
                if (pointer != minNode) {
                    tree += "->";
                }
            } 
            while (pointer != minNode && pointer.right != null);
            tree += "\n" + "The heap has " + nodeCount + " nodes.";
        }
        System.out.println(tree);
    }

    /**
     * Test1.
     * @param fh a thing
     */
    public void test1(FibonacciHeap fh) {
        System.out.println("Running test 1");
        Node n1 = new Node(6);
        Node n2 = new Node(4);
        Node n3 = new Node(8);
        fh.insert(n1);
        fh.insert(n2);
        fh.insert(n3);

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing insert. Heap should contain 4,6,8");
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Decreasing key of n2 (4) to 3");
        fh.decreaseKey(n2, 3);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println(("Testing find min. Should return 3"));
        System.out.println(fh.findMin().key);
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete min. Heap should contain 6,8");
        fh.deleteMin();
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 6. Heap should contain 8");
        fh.delete(n1);
        System.out.println("The new min should be 8. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 8. Heap should contain nothing.");
        fh.delete(n3);
        System.out.println("The new min should be null. Min is: " + fh.findMin());
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");
    }

    /**
     * Test2.
     * @param fh a thing
     */
    public void test2(FibonacciHeap fh) {
        System.out.println("Running test 2");
        Node n1 = new Node(6);
        Node n2 = new Node(4);
        Node n3 = new Node(8);
        fh.insert(n1);
        fh.insert(n2);
        fh.insert(n3);
          
        System.out.println("-----------------------------------------------------");
        System.out.println("Testing insert. Heap should contain 4,6,8");
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Decreasing key of n2 (4) to 3");
        fh.decreaseKey(n2, 3);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println(("Testing find min. Should return 3"));
        System.out.println(fh.findMin().key);
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete min. Heap should contain 6,8");
        fh.deleteMin();
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 8. Heap should contain 6");
        fh.delete(n3);
        System.out.println("The new min should be 6. Min is: " + fh.findMin().key);
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");

        System.out.println("-----------------------------------------------------");
        System.out.println("Testing delete on 6. Heap should contain nothing.");
        fh.delete(n2);
        System.out.println("The new min should be null. Min is: " + fh.findMin());
        fh.displayHeap();
        System.out.println("-----------------------------------------------------\n");
    }
    
    /**
     * Main method.
     * @param args commandline arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Creating Fibonacci Heap");
        FibonacciHeap fh = new FibonacciHeap();
     
        fh.test1(fh);
        fh.test2(fh);
    }
}

