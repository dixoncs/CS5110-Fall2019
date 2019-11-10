import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
* HeapDriverTest.java
* @author Courtney Dixon and Alisha Sprinkle
* @version 11/9/2019
*/
public class HeapDriverTest 
{
    /**
    * Tests that HeapDriver, FibonacciHeap, and HollowHeap classes exist.
    */
    @Test
    public void testClassesExists()
    {
        Class d;
        Class f;
        Class h;
        try
        {
            d = Class.forName("HeapDriver");
            f = Class.forName("FibonacciHeap");
            h = Class.forName("HollowHeap");
        } 
        catch (Exception e)
        {
            fail("Did you name the classes correctly? " + e);
        }
    }

    /**
    * Tests FibonacciHeap constructor.
    */
    @Test
    public void testFibonacciHeapConstructor()
    {
        try
        {
            FibonacciHeap fHeap = new FibonacciHeap();
        } 
        catch (Exception ex)
        {
            fail("Constructor did not work. " + ex);
        }
    }

    /**
    * Tests HollowHeap constructor.
    */
    @Test
    public void testHollowHeapConstructor()
    {
        try
        {
            HollowHeap hHeap = new HollowHeap();
        }
        catch (Exception ex)
        {
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

