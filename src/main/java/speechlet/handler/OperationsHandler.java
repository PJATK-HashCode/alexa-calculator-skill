package speechlet.handler;

import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;
import speechlet.handler.geometric.IGeometricOperationsTwoVariableHandler;
import speechlet.handler.geometric.impl.*;
import speechlet.handler.linear.IQuadraticOperationsHandler;
import speechlet.handler.linear.impl.QuadraticOperationsHandler;
import speechlet.handler.simple.ISimpleOperationsHandler;
import speechlet.handler.simple.impl.SimpleOperationsHandler;

/**
 * @author L on 28.12.2016.
 */
public class OperationsHandler implements IOperationsHandler {

    public final static String WRONG_REQUEST = "Sorry, I don't understand your request. Please repeat it.";
    public final static String RESULT_OF_MATH_OPERATION = "The result of your math operation equals ";

    public ISimpleOperationsHandler simpleOperations() {
        return new SimpleOperationsHandler();
    }

    @Override
    public IGeometricOperationsSingleVariableHandler circleOperations() {
        return new CircleHandler();
    }

    @Override
    public IGeometricOperationsSingleVariableHandler cubeOperations() {
        return new CubeHandler();
    }

    @Override
    public IGeometricOperationsThreeVariableHandler triangleOperations() {
        return new TriangleHandler();
    }

    @Override
    public IQuadraticOperationsHandler quadraticOperations() {
        return new QuadraticOperationsHandler();
    }

    @Override
    public IGeometricOperationsSingleVariableHandler sphereOperations() {
        return new SphereHandler();
    }

    @Override
    public IGeometricOperationsThreeVariableHandler pyramidOperations() {
        return new PyramidHandler();
    }

    @Override
    public IGeometricOperationsThreeVariableHandler cuboidOperations() {
        return new CuboidHandler();
    }

    @Override
    public IGeometricOperationsTwoVariableHandler rectangleOperations() {
        return new RectangleHandler();
    }

    @Override
    public IGeometricOperationsSingleVariableHandler squareOperations() {
        return new SquareHandler();
    }
}
