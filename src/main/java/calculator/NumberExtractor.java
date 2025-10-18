package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/*
    NumberExtractor 클래스
    - 역할 : 입력한 문자열에서 숫자들 추출
    - 기능
        1. 문자열에서 숫자 추출
 */
public class NumberExtractor {

    public List<Double> extractNumber(String input, List<String> delimiter) {
        // 커스텀 구분자를 지정한 경우, 숫자를 입력한 문자열 부분만 추출
        input = extractNumberPart(input);

        // 문자열에서 숫자들 각각 분리
        String[] numbers = splitNumber(input, delimiter);

        List<Double> extractNumbers = new ArrayList<>();
        for (String num : numbers) {
            num = normalizeEmpty(num); // 빈 문자열 0으로 처리

            // 분리한 문자열이 0, 양의 실수인지 검증
            if (!isPositiveNumber(num)) {
                throw new IllegalArgumentException("잘못된 입력 : \"" + num + "\"");
            }

            extractNumbers.add(Double.parseDouble(num));
        }

        return extractNumbers;
    }

    private static String extractNumberPart(String input) {
        String regex = "^//([^\\d\\s])\\\\n(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(input);

        // 커스텀 구분자를 지정한 경우
        if (matcher.find()) {
            input = matcher.group(2);
        }

        return input;
    }

    private static String[] splitNumber(String input, List<String> delimiter) {
        String delimiterRegex = delimiter.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return input.split(delimiterRegex);
    }

    private static String normalizeEmpty(String num) {
        return num.isEmpty() ? "0" : num;
    }

    private static boolean isPositiveNumber(String num) {
        return num.matches("\\d+(\\.\\d+)?");
    }
}
