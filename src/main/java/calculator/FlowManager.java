package calculator;

import java.util.List;

/*
    FlowManager 클래스
    - 역할 : 프로그램의 흐름대로 동작하도록, 각 클래스를 적절하게 사용
    - 기능
        1. 프로그램 전체 흐름 제어
            - 입력 -> 구분자 추출 -> 숫자 추출 -> 계산 -> 출력
        2. 예외 발생 시 사용자에게 오류 메시지를 출력
 */
public class FlowManager {

    void execute() {
        try {
            // 1. 사용자 입력
            IOManager ioManager = new IOManager();
            String input = ioManager.input();

            // 2. 입력된 문자열에서 구분자 추출
            DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
            List<String> strings = delimiterExtractor.delimiterExtract(input);

            // 3. 입력된 문자열에서 숫자 추출
            NumberExtractor extractor = new NumberExtractor();
            List<Double> list = extractor.extractNumber(input, strings);

            // 4. 추출된 숫자들 계산
            Calculator calculator = new Calculator();
            Double result = calculator.calculate(list);

            // 5. 결과 출력
            ioManager.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
