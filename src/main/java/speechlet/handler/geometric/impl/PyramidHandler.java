package speechlet.handler.geometric.impl;

import domain.operations.geometric.Pyramid;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-10.
 */
public class PyramidHandler implements IGeometricOperationsThreeVariableHandler {
    @Override
    public String operator(int X, int Y, int Z, String operator) {
        Pyramid pyramid = new Pyramid(X,Y,Z);
        if ("field".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(pyramid.fieldCalc());

        }
        else if ("volume".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(pyramid.volumeCalc());
        }
        return WRONG_REQUEST;
    }
}
