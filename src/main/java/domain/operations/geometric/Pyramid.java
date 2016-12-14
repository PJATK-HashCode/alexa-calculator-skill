package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Pyramid extends SpatialFigures {

    private int r,h,l;

    public Pyramid(int r, int h, int l) {
        this.r = r;
        this.h = h;
        this.l = l;
    }


    public int fieldCalc() {
        return (int)(Math.PI*(r*r)+Math.PI*r*l);
    }

    public int volumeCalc() {
        return (int)( Math.PI *(r*r)*h/3);
    }
}
