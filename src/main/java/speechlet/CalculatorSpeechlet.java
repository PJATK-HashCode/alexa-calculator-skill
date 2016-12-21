package speechlet;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import domain.operations.simple.SimpleOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author L on 08.12.2016.
 */
public class CalculatorSpeechlet implements Speechlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorSpeechlet.class);

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

        Intent intent = intentRequest.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        //TODO implementation of calculator methods
        if("HashCodeCalculator".equals(intentName))return getWelcomeResponse();
        else if("AMAZON.StopIntent".equals(intentName)){
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("GoodBye");
            return SpeechletResponse.newTellResponse(outputSpeech);
        }
        else if("Simple".equals(intentName)){

        }
        else{
            throw new SpeechletException("Invalid intent");
        }
        return null;
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest sessionEndedRequest, final Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", sessionEndedRequest.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getWelcomeResponse() {

        String speechText = "Welcome to the Calculator Skill";

        SimpleCard card = new SimpleCard();
        card.setTitle("Hello");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newTellResponse(speech, card);
    }


    private void simpleOperation (IntentRequest intentRequest, Session session) throws SpeechletException {

        SimpleOperations simpleOperations = new SimpleOperations();
        simpleOperations.add();

    }



}
