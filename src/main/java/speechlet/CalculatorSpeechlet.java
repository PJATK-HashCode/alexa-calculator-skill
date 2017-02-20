package speechlet;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import domain.operations.linear.LinearEquations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import speechlet.handler.IOperationsHandler;
import speechlet.handler.OperationsHandler;

import javax.xml.ws.Response;
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

        int x = 0;
        int y = 0;
        int z = 0;

        SpeechletResponse response = new SpeechletResponse();
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        SimpleCard card = new SimpleCard();

        Intent intent = intentRequest.getIntent();
        final Map<String, Slot> map = intent.getSlots();
        String intentName = intent.getName();


        if (map.containsKey("xValue")) {
            x = Integer.valueOf(map.get("xValue").getValue());
        }
        if (map.containsKey("yValue")) {
            y = Integer.valueOf(map.get("yValue").getValue());

        }
        if (map.containsKey("zValue")) {
            z = Integer.valueOf(map.get("zValue").getValue());

        }


        if ("AMAZON.StopIntent".equals(intentName)) {
            speech.setText("Goodbye");

        } else if ("SimpleOperation".equals(intentName)) {
            speech.setText(operationsHandler.simpleOperations()
                    .operator(x, y, map.get("operation").getValue()));

        } else if ("LinearEquation".equals(intentName)) {
            LinearEquations linearEquations = new LinearEquations();
            linearEquations.setA(x);
            linearEquations.setB(y);
            speech.setText(String.valueOf(linearEquations.calculateX()));

        } else if ("QuadraticEquation".equals(intentName)) {
            speech.setText(operationsHandler.quadraticOperations()
                    .operator(x, y, z, map.get("kind").getValue()));

        } else if ("CircleOperation".equals(intentName)) {
            speech.setText(operationsHandler.circleOperations()
                    .operator(x, map.get("CircleOp").getValue()));

        } else if ("CubeOperation".equals(intentName)) {
            speech.setText(operationsHandler.cubeOperations()
                    .operator(x, map.get("CubeOp").getValue()));

        } else if ("TriangleOperation".equals(intentName)) {
            speech.setText(operationsHandler.triangleOperations()
                    .operator(x, y, z, map.get("TriangleOp").getValue()));

        } else if ("CuboidOperation".equals(intentName)) {
            speech.setText(operationsHandler.cuboidOperations()
                    .operator(x, y, z, map.get("CuboidOp").getValue()));

        } else if ("PyramidOperation".equals(intentName)) {
            speech.setText(operationsHandler.pyramidOperations()
                    .operator(x, y, z, map.get("PyramidOp").getValue()));

        } else if ("RectangleOperation".equals(intentName)) {
            speech.setText(operationsHandler.rectangleOperations()
                    .operator(x, y, map.get("RectangleOp").getValue()));

        } else if ("SphereOperation".equals(intentName)) {
            speech.setText(operationsHandler.sphereOperations()
                    .operator(x, map.get("SphereOp").getValue()));

        } else if ("SquareOperation".equals(intentName)) {
            speech.setText(operationsHandler.squareOperations()
                    .operator(x, map.get("SquareOp").getValue()));

        } else {
            throw new SpeechletException("Invalid intent");
        }

        card.setTitle(intentName);
        card.setContent(speech.getText());

        response.setOutputSpeech(speech);
        response.setCard(card);
        response.setShouldEndSession(false);

        return response;
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest sessionEndedRequest, final Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome to the Calculator Skill, made by science club HashCode" +
                "at Gdansk branch of Polish-Japanese Academy Of Technology in Warsaw.";

        SimpleCard card = new SimpleCard();
        card.setTitle("WelcomeResponse");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        SpeechletResponse response = new SpeechletResponse();
        response.setCard(card);
        response.setOutputSpeech(speech);
        response.setShouldEndSession(false);

        return response;
    }


}




