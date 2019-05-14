package uk.gov.metoffice.hello.rjr;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RjrHelloAgainLambdaHandler implements RequestHandler<RepeatStringInstructions, String> {

    @Override
    public String handleRequest(RepeatStringInstructions repeatStringInstructions, Context context) {

        if (repeatStringInstructions == null
                || repeatStringInstructions.getRepeatable() == null
                || repeatStringInstructions.getTimes() == null) {
            return "Unable to process instructions: " + repeatStringInstructions;
        }

        return IntStream.range(0, repeatStringInstructions.getTimes())
                .mapToObj(i -> repeatStringInstructions.getRepeatable())
                .collect(Collectors.joining(","));
    }
}
