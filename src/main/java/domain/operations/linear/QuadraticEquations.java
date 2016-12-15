package domain.operations.linear;

import static java.lang.Math.sqrt;
public class QuadraticEquations {
	
    private double y;
    private double x_index;
    private double x_sq_index;
    private double delta;
    private double zero_1;
    private double zero_2;


    public double CalculateDeltaX() {
        return delta = sqrt(x_index * x_index - 4 * x_sq_index * y);
    }

	    //TODO #2 Make Zero() return double
	    public double Zero1() {
	            zero_1 = (-1 * x_index - delta) / (2 * x_sq_index);
	        return zero_1;
	    }
	    public double Zero2() {
            zero_2 = (-1 * x_index + delta) / (2 * x_sq_index);
        return zero_2;
    }
}
