package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Square extends PlaneFigures {

    private int a;


    public Square(int a) {
        this.a = a;
    }

    public int circuitCalc() {
        return 4*a;
    }

    public int fieldCalc() {
        return a*a;
    }
}
