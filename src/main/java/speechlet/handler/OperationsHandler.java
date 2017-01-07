package speechlet.handler;

import speechlet.handler.geometric.IGeometricOperationsSingleVariableHandler;
import speechlet.handler.geometric.IGeometricOperationsThreeVariableHandler;
import speechlet.handler.geometric.impl.CircleHandler;
import speechlet.handler.geometric.impl.CubeHandler;
import speechlet.handler.geometric.impl.TriangleHandler;
import speechlet.handler.linear.IQuadraticOperationsHandler;
import speechlet.handler.linear.impl.QuadraticOperationsHandler;
import speechlet.handler.simple.ISimpleOperationsHandler;
import speechlet.handler.simple.impl.SimpleOperationsHandler;

/**
 * @author L on 28.12.2016.
 */
public abstract class OperationsHandler implements IOperationsHandler {

    public final static String WRONG_REQUEST = "Sorry, I don't understand your request. Please repeat it.";

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

    public IQuadraticOperationsHandler quadraticOperations() {
        return new QuadraticOperationsHandler();
    }
}
