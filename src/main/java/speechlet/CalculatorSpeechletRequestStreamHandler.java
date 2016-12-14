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
        //TODO add app id
    }

    public CalculatorSpeechletRequestStreamHandler() {
        super(new CalculatorSpeechlet(), supportedApplicationIds);
    }
}
