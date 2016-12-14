package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Rectangle extends PlaneFigures{

    private int a,b;


    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int circuitCalc() {
        return (2*a)+(2*b);
    }

    public int fieldCalc() {
        return a*b;
    }
}
