package speechlet.handler.geometric.impl;

import domain.operations.geometric.Circle;
import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-07.
 */
public class CircleHandler implements IGeometricOperationsSingleVariableHandler {
    @Override
    public String operator(int X, String operator) {
        Circle circle = new Circle(X);

        if ("field".equals(operator)) {
            return RESULT_OF_MATH_OPERATION + String.valueOf(circle.fieldCalc());
        } else if ("circuit".equals(operator)) {
            return RESULT_OF_MATH_OPERATION + String.valueOf(circle.circuitCalc());
        }
        return WRONG_REQUEST;
    }
}
