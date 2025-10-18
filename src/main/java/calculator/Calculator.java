package calculator;

import java.util.List;

/*
    Calculator 클래스
    - 역할 : 추출된 숫자들 계산
    - 기능
        1. 숫자들을 더해 최종 합을 구함
 */
public class Calculator {
    public Double calculate(List<Double> numbers) {
        Double result = 0.0;
        for (Double num : numbers) {
            result += num;
        }
        return result;
    }
}
