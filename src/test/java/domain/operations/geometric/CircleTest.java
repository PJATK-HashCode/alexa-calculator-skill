package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mela on 2016-12-15.
 */
public class CircleTest {

    Circle circle = new Circle(5);

    @Test
    public void calculate_cirlce_circuit_test(){Assert.assertEquals(31,circle.circuitCalc());}

    @Test
    public void calculate_cirlce_field_test(){Assert.assertEquals(78,circle.fieldCalc());}


}
