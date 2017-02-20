package speechlet.handler.geometric.impl;

import domain.operations.geometric.Cube;
import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-07.
 */
public class CubeHandler implements IGeometricOperationsSingleVariableHandler {
    @Override
    public String operator(int X, String operator) {
        Cube cube = new Cube(X);

        if ("field".equals(operator)) {
            return RESULT_OF_MATH_OPERATION +String.valueOf(cube.fieldCalc());
        } else if ("volume".equals(operator)) {
            return RESULT_OF_MATH_OPERATION +String.valueOf(cube.volumeCalc());
        }
        return WRONG_REQUEST;
    }
}
