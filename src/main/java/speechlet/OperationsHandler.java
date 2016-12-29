package speechlet;

import domain.operations.linear.QuadraticEquations;
import domain.operations.simple.SimpleOperations;

/**
 * @author L on 28.12.2016.
 */
public class OperationsHandler {

    private final static String WRONG_REQUEST = "Sorry, I don't understand your request. Please repeat.";

    protected String simpleOperations(int number1, int number2, String operator) {

        SimpleOperations simpleOperations = new SimpleOperations();
        simpleOperations.setA(number1);
        simpleOperations.setB(number2);

        if ("add".equals(operator)) {

            return String.valueOf(simpleOperations.add());
        } else if ("sublimate".equals(operator)) {
            return String.valueOf(simpleOperations.sub());
        } else if ("multiply".equals(operator)) {
            return String.valueOf(simpleOperations.mul());
        } else if ("divide".equals(operator)) {
            return String.valueOf(simpleOperations.div());
        } else if ("exponentiation".equals(operator)) {
            return String.valueOf(simpleOperations.inv());
        }

        return WRONG_REQUEST;
    }

    protected String quadraticOperations(int number1, int number2, int number3, String operator) {

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
