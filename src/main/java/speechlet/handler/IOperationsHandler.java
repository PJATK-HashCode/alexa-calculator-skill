package speechlet.handler;

import speechlet.handler.linear.IQuadraticOperationsHandler;
import speechlet.handler.simple.ISimpleOperationsHandler;

/**
 * Created by Kuba on 2016-12-29.
 */
public interface IOperationsHandler {
    ISimpleOperationsHandler simpleOperations();
    IQuadraticOperationsHandler quadraticOperations();
}
