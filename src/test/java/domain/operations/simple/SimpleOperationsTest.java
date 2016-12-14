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
    public void setUp() throws Exception {

        simpleOperations = new SimpleOperations();
        simpleOperations.setA(2.0);
        simpleOperations.setB(4.0);

    }

    @Test
    public void testMultiply() {

        assertEquals(8.0, simpleOperations.mul(), 0.1);
    }

    @Test
    public void testAddition() {

        assertEquals(6.0, simpleOperations.add(), 0.1);
    }
    
    @Test
    public void testSubstract() {

        assertEquals(-2.0, simpleOperations.sub(), 0.1);
    }
    
    @Test
    public void testDivide() {

        assertEquals(0.5, simpleOperations.div(), 0.1);
    }
    
    @Test
    public void testInvolution() {

        assertEquals(16, simpleOperations.inv(), 0.1);
    }
    
    @Test
    public void testRoot() {

        assertEquals(2, simpleOperations.sqrt(), 0.1);
    }
}