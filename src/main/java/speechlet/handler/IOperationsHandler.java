package speechlet.handler;

import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;
import speechlet.handler.geometric.IGeometricOperationsTwoVariableHandler;
import speechlet.handler.linear.IQuadraticOperationsHandler;
import speechlet.handler.simple.ISimpleOperationsHandler;

/**
 * Created by Kuba on 2016-12-29.
 */
public interface IOperationsHandler {

    ISimpleOperationsHandler simpleOperations();

    IGeometricOperationsSingleVariableHandler circleOperations();

    IQuadraticOperationsHandler quadraticOperations();

    IGeometricOperationsSingleVariableHandler cubeOperations();

    IGeometricOperationsThreeVariableHandler triangleOperations();

    IGeometricOperationsSingleVariableHandler sphereOperations();

    IGeometricOperationsThreeVariableHandler pyramidOperations();

    IGeometricOperationsThreeVariableHandler cuboidOperations();

    IGeometricOperationsTwoVariableHandler rectangleOperations();

    IGeometricOperationsSingleVariableHandler squareOperations();

}
