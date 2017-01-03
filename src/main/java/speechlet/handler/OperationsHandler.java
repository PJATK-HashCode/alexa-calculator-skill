package speechlet.handler;

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

    public IQuadraticOperationsHandler quadraticOperations() {
        return new QuadraticOperationsHandler();
    }
}
