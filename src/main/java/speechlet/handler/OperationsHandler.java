package speechlet.handler;

import com.amazon.speech.slu.Slot;
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

import java.util.Map;

/**
 * @author L on 28.12.2016.
 */
public class OperationsHandler {

    public final static String WRONG_REQUEST = "Sorry, I don't understand your request. Please repeat it.";
    public final static String RESULT_OF_MATH_OPERATION = "The result of your math operation equals ";


    public String singleVariableHandler(String intent, int X, Map<String, Slot> map) {
        try {
            switch (intent) {
                case "CircleOperation": {
                    return new CircleHandler().operator(X, map.get("CircleOp").getValue());
                }
                case "CubeOperation": {
                    return new CubeHandler().operator(X, map.get("CubeOp").getValue());
                }
                case "SphereOperation": {
                    return new SphereHandler().operator(X, map.get("SphereOp").getValue());
                }
                case "SquareOperation": {
                    return new SquareHandler().operator(X, map.get("SquareOp").getValue());
                }
                default:
                    return ("Invalid intent");
            }
        } catch (NullPointerException ex) {
            throw new NullPointerException("Invalid intent");
        }
    }

    public String TwoVariableHandler(String intent, int X, int Y, Map<String, Slot> map) {
        switch (intent) {
            case "RectangleOperation": {
                return new RectangleHandler().operator(X, Y, map.get("RectangleOp").getValue());
            }
            case "SimpleOperation": {
                return new SimpleOperationsHandler().operator(X, Y, map.get("operation").getValue());
            }
            case "LinearEquation": {
                LinearEquations linearEquations = new LinearEquations();
                linearEquations.setA(X);
                linearEquations.setB(Y);
                return String.valueOf(linearEquations.calculateX());
            }
            default:
                return "Invalid intent";

        }
    }

    public String ThreeVariableHandler(String intent, int X, int Y, int Z, Map<String, Slot> map) {
        switch (intent) {
            case "triangleOperation": {
                return new TriangleHandler().operator(X, Y, Z, map.get("TriangleOp").getValue());
            }
            case "pyramidOperation": {
                return new PyramidHandler().operator(X, Y, Z, map.get("PyramidOp").getValue());
            }
            case "CuboidOperation": {
                return new CuboidHandler().operator(X, Y, Z, map.get("CuboidOp").getValue());
            }
            case "QuadraticEquation": {
                return new QuadraticOperationsHandler().operator(X, Y, Z, map.get("QuadraticOp").getValue());
            }
            default:
                return "Invalid intent";
        }
    }

}
