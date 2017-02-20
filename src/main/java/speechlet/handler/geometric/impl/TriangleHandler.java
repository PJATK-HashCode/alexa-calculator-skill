package speechlet.handler.geometric.impl;

import domain.operations.geometric.Triangle;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-07.
 */
public class TriangleHandler implements IGeometricOperationsThreeVariableHandler {
    @Override
    public String operator(int X, int Y, int Z, String operator) {
        Triangle triangle = new Triangle(X, Y, Z);
        if ("field".equals(operator)) {
            return RESULT_OF_MATH_OPERATION + String.valueOf(triangle.fieldCalc());
        } else if ("circuit".equals(operator)) {
            return RESULT_OF_MATH_OPERATION + String.valueOf(triangle.circuitCalc());
        }
        return WRONG_REQUEST;
    }
}
