package domain.operations.geometric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kuba on 2016-12-13.
 */
public class PyramidTest {
    private Pyramid pyramid = new Pyramid(5,5,5);
    @Test
    public void calculate_pyramid_field_test(){
        Assert.assertEquals(157, pyramid.fieldCalc());
    }
    @Test
    public void calculate_pyramid_volume_test(){
        Assert.assertEquals(130, pyramid.volumeCalc());
    }

}
