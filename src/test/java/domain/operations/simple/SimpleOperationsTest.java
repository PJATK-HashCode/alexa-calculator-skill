package domain.operations.simple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author L on 08.12.2016.
 */
public class SimpleOperationsTest {

    private SimpleOperations simpleOperations;

    @Before
    public void set_up() throws Exception {

        simpleOperations = new SimpleOperations();
        simpleOperations.setA(2.0);
        simpleOperations.setB(4.0);

    }

    @Test
    public void test_multiply() {

        assertEquals(8.0, simpleOperations.mul(), 0.1);
    }

    @Test
    public void test_addition() {

        assertEquals(6.0, simpleOperations.add(), 0.1);
    }
    
    @Test
    public void test_subtract() {

        assertEquals(-2.0, simpleOperations.sub(), 0.1);
    }
    
    @Test
    public void test_divide() {

        assertEquals(0.5, simpleOperations.div(), 0.1);
    }
    
    @Test
    public void test_involution() {

        assertEquals(16, simpleOperations.inv(), 0.1);
    }
    

}