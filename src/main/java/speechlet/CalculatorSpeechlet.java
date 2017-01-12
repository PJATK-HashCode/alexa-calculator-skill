package speechlet;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import domain.operations.linear.LinearEquations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import speechlet.handler.IOperationsHandler;
import speechlet.handler.OperationsHandler;

import java.util.Map;

/**
 * @author L on 08.12.2016.
 */
public class CalculatorSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorSpeechlet.class);
    private IOperationsHandler operationsHandler = new OperationsHandler();


    @Override
    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", sessionStartedRequest.getRequestId(),
                session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", intentRequest.getRequestId(), session.getSessionId());

        SpeechletResponse response = new SpeechletResponse();
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();

        Intent intent = intentRequest.getIntent();
        final Map<String, Slot> map = intent.getSlots();
        String intentName = (intent != null) ? intent.getName() : null;

        int x = Integer.valueOf(map.get("xValue").getValue());
        int y = Integer.valueOf(map.get("yValue").getValue());
        int z = Integer.valueOf(map.get("zValue").getValue());

        //TODO implementation of calculator methods
        if ("HashCodeCalculator".equals(intentName)) return getWelcomeResponse();
        else if ("AMAZON.StopIntent".equals(intentName)) {

            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("GoodBye");

            return SpeechletResponse.newTellResponse(outputSpeech);

        } else if ("SimpleOperation".equals(intentName)) {
            if (map.containsKey("xValue") && map.containsKey("yValue") && map.containsKey("operation")) {

                speech.setText(operationsHandler.simpleOperations().operator(x, y, map.get("operation").getValue()));
            }
        } else if ("LinearEquation".equals(intentName)) {

            LinearEquations linearEquations = new LinearEquations();

            if (map.containsKey("xValue") && map.containsKey("yValue")) {

                linearEquations.setA(x);
                linearEquations.setB(y);

                speech.setText(String.valueOf(linearEquations.calculateX()));
            }

        } else if ("QuadraticEquation".equals(intentName)) {

            if (map.containsKey("xValue") && map.containsKey("yValue")
                    && map.containsKey("zValue") && map.containsKey("kind")) {


                speech.setText(operationsHandler.quadraticOperations().operator(x, y, z, map.get("kind").getValue()));
            }
        } else if ("CircleOperation".equals(intentName)) {
            if (map.containsKey("xValue")) {
                speech.setText(operationsHandler.circleOperations().operator(x, map.get("CircleOp").getValue()));
            }
        } else if ("CubeOperation".equals(intentName)) {

            if (map.containsKey("xValue")) {
                speech.setText(operationsHandler.cubeOperations().operator(x, map.get("CubeOp").getValue()));
            }
        } else if ("TriangleOperation".equals(intentName)) {

            if (map.containsKey("xValue") && map.containsKey("yValue") && map.containsKey("zValue")) {
                 speech.setText(operationsHandler.triangleOperations().operator(x, y, z, map.get("TriangleOp").getValue()));
            }
        } else if ("CuboidOperation".equals(intentName)) {
            if (map.containsKey("xValue") && map.containsKey("yValue") && map.containsKey("zValue")) {

                speech.setText(operationsHandler.cuboidOperations().operator(x, y, z, map.get("CuboidOp").getValue()));
            }
        }
        else if ("PyramidOperation".equals(intentName)){
            if (map.containsKey("xValue") && map.containsKey("yValue") && map.containsKey("zValue")) {

                speech.setText(operationsHandler.pyramidOperations().operator(x, y, z, map.get("PyramidOp").getValue()));
            }
            }
        else if ("RectangleOperation".equals(intentName)){
            if (map.containsKey("xValue") && map.containsKey("yValue")) {

                speech.setText(operationsHandler.rectangleOperations().operator(x, y, map.get("RectangleOp").getValue()));
            }
        }
        else if ("SphereOperation".equals(intentName)){
            if (map.containsKey("xValue")) {
                speech.setText(operationsHandler.sphereOperations().operator(x, map.get("SphereOp").getValue()));
            }
        }
        else if ("SquareOperation".equals(intentName)){
            if (map.containsKey("xValue")) {
                speech.setText(operationsHandler.squareOperations().operator(x, map.get("SquareOp").getValue()));
            }

        }


        else {
            throw new SpeechletException("Invalid intent");
        }

        response.setOutputSpeech(speech);
        response.setShouldEndSession(true);
        return response;
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest sessionEndedRequest, final Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome to the Calculator Skill. What do you want to do?";

        SimpleCard card = new SimpleCard();
        card.setTitle("WelcomeResponse");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newTellResponse(speech, card);
    }


}




