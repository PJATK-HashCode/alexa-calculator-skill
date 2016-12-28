package domain.operations.linear;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearEquationsTest {

    private LinearEquations linearEquations;

    @Before
    public void set_up() {
        linearEquations = new LinearEquations();
        linearEquations.setA(2);
        linearEquations.setB(4);
    }

    @Test
    public void calculate_zero_point() {

        assertEquals(2, linearEquations.calculateX(), 0.001);

    }


}
