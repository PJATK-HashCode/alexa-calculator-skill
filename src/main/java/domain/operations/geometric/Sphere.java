package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Sphere extends SpatialFigures {

    private int r;


    public Sphere(int r) {
        this.r = r;
    }

    public int volumeCalc() {
        return (int) (4/3*Math.PI*r*r*r);
    }

    public int fieldCalc() {
        return (int) (4*Math.PI*r*r);
    }
}
