package uk.gov.metoffice.hello.rjr;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class RjrHelloAgainLambdaHandlerTest {

    private RjrHelloAgainLambdaHandler testObject;

    @Before
    public void setUp() {
        testObject = new RjrHelloAgainLambdaHandler();
    }

    @Test
    public void handleRequestAllWell() {
        // arrange
        List<RepeatStringInstructions> inputs = Arrays.asList(
                new RepeatStringInstructions(1, "hello"),
                new RepeatStringInstructions(3, "yeah"),
                new RepeatStringInstructions(0, "oops"),
                new RepeatStringInstructions(23, "x")
        );
        List<String> expectedOutputs = Arrays.asList(
                "hello",
                "yeah,yeah,yeah",
                "",
                "x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x"
        );

        // act
        List<String> results = inputs.stream()
                .map(input -> testObject.handleRequest(input, null))
                .collect(Collectors.toList());

        // assert
        assertEquals(expectedOutputs, results);
    }

    @Test
    public void testWithNulls() {
        // arrange
        List<RepeatStringInstructions> inputs = Arrays.asList(
                null,
                new RepeatStringInstructions(null, "hello"),
                new RepeatStringInstructions(3, null)
        );
        List<String> expectedOutputs = Arrays.asList(
                "Unable to process instructions: null",
                "Unable to process instructions: RepeatStringInstructions{times=null, repeatable='hello'}",
                "Unable to process instructions: RepeatStringInstructions{times=3, repeatable='null'}"
        );

        // act
        List<String> results = inputs.stream()
                .map(input -> testObject.handleRequest(input, null))
                .collect(Collectors.toList());

        // assert
        assertEquals(expectedOutputs, results);
    }
}