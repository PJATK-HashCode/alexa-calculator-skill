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

}