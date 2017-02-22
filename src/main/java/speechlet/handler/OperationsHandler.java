package speechlet.handler;

import com.amazon.speech.speechlet.SpeechletException;
import domain.operations.linear.LinearEquations;
import org.apache.commons.lang3.ObjectUtils;
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
public class OperationsHandler  {

    public final static String WRONG_REQUEST = "Sorry, I don't understand your request. Please repeat it.";
    public final static String RESULT_OF_MATH_OPERATION = "The result of your math operation equals ";


    public String singleVariableHandler(String intent, int X, String operation) {
        try {
            switch (intent) {
                case "CircleOperation": {
                    return new CircleHandler().operator(X,operation);
                }
                case "CubeOperation": {
                    return new CubeHandler().operator(X,operation);
                }
                case "SphereOperation": {
                    return new SphereHandler().operator(X,operation);
                }
                case "SquareOperation": {
                    return new SquareHandler().operator(X,operation);
                }
                default:
                    return ("Invalid intent");
            }
        }catch (NullPointerException ex){
            throw new NullPointerException("Invalid intent");
        }
    }

    public String TwoVariableHandler(String intent, int X, int Y, String operation){
        switch(intent){
            case "RectangleOperation": {
                return new RectangleHandler().operator(X,Y,operation);
            }
            case "SimpleOperation": {
                return new SimpleOperationsHandler().operator(X,Y,operation);
            }
            case "LinearEquation": {
                LinearEquations linearEquations = new LinearEquations();
                linearEquations.setA(X);
                linearEquations.setB(Y);
                return String.valueOf(linearEquations.calculateX());
            }
            default: return "Invalid intent";

        }
    }

    public String ThreeVariableHandler(String intent, int X, int Y,int Z, String operation){
        switch (intent){
            case "triangleOperation": {
                return new TriangleHandler().operator(X,Y,Z,operation);
            }
            case "pyramidOperation": {
                return new PyramidHandler().operator(X,Y,Z,operation);
            }
            case "CuboidOperation":{
                return new CuboidHandler().operator(X,Y,Z,operation);
            }
            case "QuadraticEquation": {
                return new QuadraticOperationsHandler().operator(X,Y,Z,operation);
            }
            default: return "Invalid intent";
        }
    }

}
