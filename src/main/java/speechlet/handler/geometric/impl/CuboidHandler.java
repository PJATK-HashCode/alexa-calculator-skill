package speechlet.handler.geometric.impl;

import domain.operations.geometric.Cuboid;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;

import static speechlet.handler.OperationsHandler.RESULT_OF_MATH_OPERATION;
import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-10.
 */
public class CuboidHandler implements IGeometricOperationsThreeVariableHandler {
    @Override
    public String operator(int X, int Y, int Z, String operator) {
        Cuboid cuboid = new Cuboid(X,Y,Z);
        if ("field".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(cuboid.fieldCalc());
        }
        else if ("volume".equals(operator)){
            return RESULT_OF_MATH_OPERATION + String.valueOf(cuboid.volumeCalc());
        }
        return WRONG_REQUEST;
    }
}
