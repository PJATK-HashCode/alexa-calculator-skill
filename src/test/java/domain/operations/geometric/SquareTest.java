package domain.operations.geometric;

import org.junit.*;

/**
 * Created by Kuba on 2016-12-10.
 */
public class SquareTest {
    Square square = new Square(5);

    @Test
    public void calculate_square_field_test(){
        Assert.assertEquals(25,square.fieldCalc());
    }
    @Test
    public void calculate_square_circuit_test(){
        Assert.assertEquals(20,square.circuitCalc());
    }
}

