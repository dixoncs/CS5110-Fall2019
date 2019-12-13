import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
* HeapDriverTest.
* @author Courtney Dixon
* @version 11/9/2019
*/
public class HeapDriverTest {
    
    /**
     * Tests that the HeapDriver class exists.
     */
    @Test
    public void testHeapDriverExists() {
        Class d;
        try {
            d = Class.forName("HeapDriver");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

    /**
     * Tests that the FibonacciHeapDriver class exists.
     */
    @Test
    public void testFibonacciHeapDriverExists() {
        Class d;
        try {
            d = Class.forName("FibonacciHeapDriver");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

    /**
     * Tests that the HollowHeapDriver class exists.
     */
    @Test
    public void testHollowHeapDriverExists() {
        Class d;
        try {
            d = Class.forName("HollowHeapDriver");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

   /**
     * Tests that the FibonacciHeap class exists.
     */
    @Test
    public void testFibonacciHeapExists() {
        Class f;
        try {
            f = Class.forName("FibonacciHeap");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }
   
    /**
     * Tests that the HollowHeap class exists.
     */
    @Test
    public void testHollowHeapExists() {
        Class h;
        try {
            h = Class.forName("HollowHeap");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

    /**
     * Tests that the Node class exists.
     */
    @Test
    public void testNodeExists() {
        Class n;
        try {
            n = Class.forName("Node");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

    /**
     * Tests that the FibonacciNode class exists.
     */
    @Test
    public void testFibonacciNodeExists() {
        Class n;
        try {
            n = Class.forName("FibonacciNode");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }

    /**
     * Tests that the HollowNode class exists.
     */
    @Test
    public void testHollowNodeExists() {
        Class hn;
        try {
            hn = Class.forName("HollowNode");
        } 
        catch (Exception e) {
            fail("Did you name the class correctly? " + e);
        }
    }
    
    /**
     * Tests FibonacciHeap constructor.
     */
    @Test
    public void testFibonacciHeapConstructor() {
        try {
            FibonacciHeap fHeap = new FibonacciHeap();
        } 
        catch (Exception ex) {
            fail("Constructor did not work. " + ex);
        }
    }

    /**
     * Tests HollowHeap constructor.
     */
    @Test
    public void testHollowHeapConstructor() {
        try {
            HollowHeap hHeap = new HollowHeap();
        }
        catch (Exception ex) {
            fail("Constructor did not work. " + ex);
        }
    }




    /**
    * Tests a method that builds something.
    */
    //@Test
    //public void test()
    //{
    //    try
    //    {
            
    //    }
    //    catch (Exception ex)
    //    {
    //        fail("FAIL.COM" + ex);
    //    }
    //}

    /**
     * Tests a method that returns/gets something.
     */
    //@Test
    //public void test()
    //{
        //make a new object
        //assign to a local variable a call the accessor method
        //if(local variable != what it should equal)
        //{
        //    fail("The thing should be this not " + local variable);
        //}
    //}

    /**
     * Test a method that sets/mutates something like a field.
     */
    //@Test
    //public void test()
    //{
        //make a new object
        //set the things with call to mutator method
        //make local variable to hold call to accessor method(s)
        //for each thing set if(local variable != what it should)
        //{
            //fail("The thing should be this, not " + local variable);
        //}
    //}

    /**
     * Tests a method that prints to output.
     */
    //@Test
    //public void test()
    //{
        //make a new object
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(baos));
        //call method that prints/displays stuff
        //System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        //String s = baos.toString();
        //if (! "the stuff it's supposed to print".equals(s))
        //{
        //    fail("Unexpected output:\n" + s + "\n");
        //}
    //}

}

