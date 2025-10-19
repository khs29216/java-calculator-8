package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterExtractorTest {

    @Test
    void 기본_구분자_추출() {
        // given
        List<String> testDelimiter = new ArrayList<>(Arrays.asList(",", ":"));
        String testInput = "1,2:3";

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        // when
        List<String> result = delimiterExtractor.extractDelimiter(testInput);

        // then
        assertEquals(testDelimiter, result);
    }

    @Test
    void 커스텀_구분자_추출() {
        // given
        List<String> testDelimiter = new ArrayList<>(Arrays.asList("d"));
        String testInput = "//d\\n1d2d3";

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        // when
        List<String> result = delimiterExtractor.extractDelimiter(testInput);

        // then
        assertEquals(testDelimiter, result);
    }
}