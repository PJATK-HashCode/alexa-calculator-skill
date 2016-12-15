package domain.operations.linear;

public class LinearEquations {

    private double x;
    private double y;
    private double result;
    private double x_index;
    private double x_sq_index;
    private double delta;
    private double zero_1;
    private double zero_2;


    public LinearEquations() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getX_index() {
        return x_index;
    }

    public void setX_index(double x_index) {
        this.x_index = x_index;
    }

    public double getX_sq_index() {
        return x_sq_index;
    }

    public void setX_sq_index(double x_sq_index) {
        this.x_sq_index = x_sq_index;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getZero_1() {
        return zero_1;
    }

    public void setZero_1(double zero_1) {
        this.zero_1 = zero_1;
    }

    public double getZero_2() {
        return zero_2;
    }

    public void setZero_2(double zero_2) {
        this.zero_2 = zero_2;
    }

    
    public double CalculateX() {
        return x = (result - y) / x_index;
    }
}
