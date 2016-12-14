package domain.operations.geometric;

/**
 * Created by Kuba on 2016-12-08.
 */
public class Triangle extends PlaneFigures {

    private int a,b,c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int circuitCalc() {
        return a+b+c;
    }

    public int fieldCalc() {
        int p=(a+b+c)/2;
        return (int)Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
