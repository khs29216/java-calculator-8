package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    DelimiterExtractor 클래스
    - 역할 : 입력한 문자열에서 구분자 추출
    - 기능
        1. 문자열에서 구분자 추출
 */
public class DelimiterExtractor {

    public List<String> delimiterExtract(String input) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        String regex = "^//([^\\d\\s.])\\\\n.*";
        if (isRegexMatch(regex, input)) {
            Matcher matcher = Pattern.compile(regex).matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                delimiters = new ArrayList<>(Arrays.asList(customDelimiter));
            }
        }
        return delimiters;
    }

    private boolean isRegexMatch(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
