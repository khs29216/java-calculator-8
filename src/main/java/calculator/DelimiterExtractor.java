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

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//([^\\d\\s.])\\\\n.*");
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    public List<String> extractDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.matches()) {
            return List.of(matcher.group(1)); // 커스텀 구분자만 반환
        }

        return new ArrayList<>(DEFAULT_DELIMITERS); // 기본 구분자 반환
    }
}
