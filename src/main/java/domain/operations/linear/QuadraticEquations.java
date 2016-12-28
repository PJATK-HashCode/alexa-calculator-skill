package domain.operations.linear;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEquations {

    private double b;
    private double a;
    private double c;

    public QuadraticEquations() {
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setC(double c) {
        this.c = c;
    }


    protected double calculateDelta() {
        return pow(b, 2) - (4 * a * c);
    }

    protected double calculateFirstZeroPoint() {

        return (-b - sqrt(calculateDelta())) / (2 * a);
    }

    protected double calculateSecondZeroPoint() {

        return (-b + sqrt(calculateDelta())) / (2 * a);

    }

    public String results() {
        return "First zero point for x equals " + calculateFirstZeroPoint() + " and second zero point equals " + calculateSecondZeroPoint();
    }
}
