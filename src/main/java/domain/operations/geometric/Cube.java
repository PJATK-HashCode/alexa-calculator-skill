package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Cube extends SpatialFigures {

    private int a;

    public Cube(int a) {
        this.a = a;
    }


    public int fieldCalc() {
        return 6*(a*a);
    }

    public int volumeCalc() {
        return a*a*a;
    }
}
