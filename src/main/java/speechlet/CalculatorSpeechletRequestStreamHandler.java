package speechlet;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author L on 08.12.2016.
 */
public class CalculatorSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.[amzn1.ask.skill.c0da1d99-24fb-446e-94c0-e1cbfa2e1a48]");

    }

    public CalculatorSpeechletRequestStreamHandler() {
        super(new CalculatorSpeechlet(), supportedApplicationIds);
    }
}
