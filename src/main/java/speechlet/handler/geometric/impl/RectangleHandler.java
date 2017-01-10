package speechlet.handler.geometric.impl;

import domain.operations.geometric.Rectangle;
import speechlet.handler.geometric.IGeometricOperationsTwoVariableHandler;

import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2017-01-10.
 */
public class RectangleHandler implements IGeometricOperationsTwoVariableHandler {
    @Override
    public String operator(int X, int Y, String operator) {
        Rectangle rectangle = new Rectangle(X,Y);
        if ("field".equals(operator)){
            return String.valueOf(rectangle.fieldCalc());
        }
        else if ("circuit".equals(operator)){
            return String.valueOf(rectangle.circuitCalc());
        }
        return WRONG_REQUEST;
    }
}
