package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Cuboid extends SpatialFigures {

    private int a,b,h;

    public Cuboid(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }


    public int fieldCalc() {
        return 2*a*b + 2*b*h + 2*a*h;
    }

    public int volumeCalc() {
        return a*b*h;
    }
}
