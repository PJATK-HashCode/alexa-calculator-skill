package domain.operations.linear;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author L on 28.12.2016.
 */
public class QuadraticEquationsTest {

    private QuadraticEquations quadraticEquations;

    @Before
    public void set_up() {

        quadraticEquations = new QuadraticEquations();
        quadraticEquations.setA(2);
        quadraticEquations.setB(3);
        quadraticEquations.setC(1);
    }

    @Test
    public void calculate_delta() {
        assertEquals(1, quadraticEquations.calculateDelta(), 0.001);
    }

    @Test
    public void calculate_first_zero_point() {
        assertEquals(-1, quadraticEquations.calculateFirstZeroPoint(), 0.001);
    }

    @Test
    public void calculate_second_zero_point() {
        assertEquals(-0.5, quadraticEquations.calculateSecondZeroPoint(), 0.001);
    }
}