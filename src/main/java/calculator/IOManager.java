package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;

/*
    IOManager 클래스
    - 역할 : 프로그램의 입력과 출력
    - 기능
        1. 사용자의 입력을 콘솔에서 받음
        2. 결과를 정해진 형식에 맞게 출력
 */
public class IOManager {
    // 사용자의 입력을 받는 매서드
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 결과를 출력하는 메서드
    public void printResult(Double num) {
        DecimalFormat df = new DecimalFormat("#.######"); // 불필요한 0 제거
        String result = df.format(num);
        System.out.println("결과 : " + result);
    }
}
