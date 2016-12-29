package speechlet.handler.linear.impl;

import domain.operations.linear.QuadraticEquations;
import speechlet.handler.linear.IQuadraticOperationsHandler;

import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2016-12-29.
 */
public class QuadraticOperationsHandler implements IQuadraticOperationsHandler {

    @Override
    public String operator(int number1, int number2, int number3, String operator) {

        QuadraticEquations quadraticEquations = new QuadraticEquations();
        quadraticEquations.setA(number1);
        quadraticEquations.setB(number2);
        quadraticEquations.setC(number3);

        if ("delta".equals(operator)) {
            return String.valueOf(quadraticEquations.calculateDelta());
        } else if ("zeroPoints".equals(operator)) {
            return quadraticEquations.results();
        }
        return WRONG_REQUEST;

    }
}
