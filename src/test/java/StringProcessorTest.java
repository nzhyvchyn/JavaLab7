import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.tools.StringProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {

    private String text;

    private String expectedText;

    private StringProcessor processor;

    @BeforeEach
    void setUp() {
        text = "BUS ROUTE: BUS#123";
        expectedText = "BUS ROUTE: BUS#BUS_UNKNOWN ";
        processor = new StringProcessor(text);
    }

    @Test
    void testTextProcessing() {
        processor.processText();
        assertEquals(expectedText, processor.showResults(),"Processing error");
    }
}


