package speechlet;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import domain.operations.linear.LinearEquations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import speechlet.handler.OperationsHandler;

import java.util.Map;

/**
 * @author L on 08.12.2016.
 */
public class CalculatorSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorSpeechlet.class);
    private OperationsHandler operationsHandler = new OperationsHandler();

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
        String operation;

        if (map.containsKey("xValue")) {
            x = Integer.valueOf(map.get("xValue").getValue());
        }
        if (map.containsKey("yValue")) {
            y = Integer.valueOf(map.get("yValue").getValue());
        }
        if (map.containsKey("zValue")) {
            z = Integer.valueOf(map.get("zValue").getValue());
        }


        if (map.containsKey("xValue") && !map.containsKey("yValue")
                && !map.containsKey("zValue") && !intentName.equals("AMAZON.StopIntent")) {
            speech.setText(operationsHandler.singleVariableHandler(intentName, x, map));
        } else if (map.containsKey("xValue") && map.containsKey("yValue")
                && !map.containsKey("zValue") && !intentName.equals("AMAZON.StopIntent")
                ) {
            speech.setText(operationsHandler.TwoVariableHandler(intentName, x, y, map));
        } else if (map.containsKey("xValue") && map.containsKey("yValue")
                && map.containsKey("zValue") && !intentName.equals("AMAZON.StopIntent")) {
            speech.setText(operationsHandler.ThreeVariableHandler(intentName, x, y, z, map));
        } else if (intentName.equals("AMAZON.StopIntent")) {
            speech.setText("Goodbye");
        } else {
            throw new SpeechletException("Invalid intent");
        }


        card.setTitle(intentName);
        card.setContent(speech.getText());
        response.setOutputSpeech(speech);
        response.setCard(card);

        return response;
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest sessionEndedRequest, final Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome in Calculator Skill, made by science club HashCode" +
                "at Gdansk branch of Polish-Japanese Academy Of Technology in Warsaw.";

        SimpleCard card = new SimpleCard();
        card.setTitle("WelcomeResponse");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        SpeechletResponse response = new SpeechletResponse();
        response.setCard(card);
        response.setOutputSpeech(speech);

        return response;
    }

}
