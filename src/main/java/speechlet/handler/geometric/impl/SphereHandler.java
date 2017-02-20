package speechlet.handler.geometric.impl;

import domain.operations.geometric.Sphere;
import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-10.
 */
public class SphereHandler implements IGeometricOperationsSingleVariableHandler {
    @Override
    public String operator(int X, String operator) {
        Sphere sphere = new Sphere(X);
        if ("field".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(sphere.fieldCalc());
        }
        else if ("volume".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(sphere.volumeCalc());
        }
        return  WRONG_REQUEST;
    }
}
