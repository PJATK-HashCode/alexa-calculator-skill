package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Circle extends PlaneFigures{

    private int r;

    public Circle(int r) {
        this.r = r;
    }

    public int circuitCalc() {
        return (int)(2* Math.PI*r);
    }

    public int fieldCalc() {
        return (int)(Math.PI*(r*r));
    }
}
