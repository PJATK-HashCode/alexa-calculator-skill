package domain.operations.geometric;
import org.junit.*;

/**
 * Created by Mela on 2016-12-15.
 */
public class SphereTest {

    Sphere sphere = new Sphere(5);

    @Test
    public void calculate_sphere_field_test(){Assert.assertEquals(314,sphere.fieldCalc());}

    @Test
    public void calculate_sphere_volume_test(){Assert.assertEquals(523,sphere.volumeCalc());}

}
