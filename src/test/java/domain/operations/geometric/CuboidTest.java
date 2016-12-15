package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kuba on 2016-12-13.
 */
public class CuboidTest {
    private Cuboid cuboid = new Cuboid(5,5,5);
    @Test
    public void calculate_cuboid_field_test(){
        Assert.assertEquals(150,cuboid.fieldCalc());
    }
    @Test
    public void calculate_cuboid_volume_test(){
        Assert.assertEquals(125,cuboid.volumeCalc());
    }
}
