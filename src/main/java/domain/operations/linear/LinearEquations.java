package domain.operations.linear;


public class LinearEquations {

    private double a;
    private double b;

    public LinearEquations() {
    }


    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }


    public double calculateX() {

        if (a != 0) {
            return b / a;
        }
        return Double.parseDouble("First number cant equals zero. Your request has no solutions");
    }
}
