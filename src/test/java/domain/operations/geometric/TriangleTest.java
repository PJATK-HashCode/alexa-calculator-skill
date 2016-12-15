package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kuba on 2016-12-11.
 */
public class TriangleTest {
    private Triangle triangle = new Triangle(6,6,6);
    @Test
    public void calculate_triangle_field_test(){
        Assert.assertEquals( (int)15,triangle.fieldCalc());
    }
    @Test
    public void calculate_triangle_circuit_test() {
        Assert.assertEquals(18,triangle.circuitCalc());
    }

}
