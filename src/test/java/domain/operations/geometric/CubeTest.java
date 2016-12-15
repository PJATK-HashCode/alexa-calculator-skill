package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mela on 2016-12-15.
 */
public class CubeTest {

    private Cube cube = new Cube(5);

    @Test
    public void calculate_cube_field_test(){Assert.assertEquals(150,cube.fieldCalc());}

    @Test
    public void calculate_cube_volume_test(){Assert.assertEquals(125,cube.volumeCalc());}
}
