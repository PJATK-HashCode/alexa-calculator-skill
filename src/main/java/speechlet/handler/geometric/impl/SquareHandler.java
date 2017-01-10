package speechlet.handler.geometric.impl;

import domain.operations.geometric.Square;
import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;

import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-10.
 */
public class SquareHandler implements IGeometricOperationsSingleVariableHandler {
    @Override
    public String operator(int X, String operator) {
        Square square = new Square(X);
        if ("field".equals(operator)){
            return String.valueOf(square.fieldCalc());
        }
        else if ("circuit".equals(operator)){
            return String.valueOf(square.circuitCalc());
        }
        return WRONG_REQUEST;
    }
}
