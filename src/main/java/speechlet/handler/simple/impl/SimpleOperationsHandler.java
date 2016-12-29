package speechlet.handler.simple.impl;


import speechlet.handler.simple.ISimpleOperationsHandler;

import static speechlet.handler.OperationsHandler.WRONG_REQUEST;

/**
 * Created by Kuba on 2016-12-29.
 */
public class SimpleOperationsHandler implements ISimpleOperationsHandler {
    private int number1;
    private int number2;
    private String operator;


    @Override
    public String operator(int number1, int number2, String operator) {

        domain.operations.simple.SimpleOperations simpleOperations = new domain.operations.simple.SimpleOperations();
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

}
