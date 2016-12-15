package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kuba on 2016-12-11.
 */
public class RectangleTest {
    private Rectangle rectangle = new Rectangle(5,10);

    @Test
    public void calculate_rectangle_field_test()
    {
        Assert.assertEquals(50,rectangle.fieldCalc());
    }
    @Test
    public void calculate_rectangle_circuit_test(){
        Assert.assertEquals(30,rectangle.circuitCalc());
    }
}
