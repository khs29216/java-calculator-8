package calculator;

import java.util.Scanner;

/*
    IOManager 클래스
    - 입력과 출력을 담당하는 역할을 한다.
        - 사용자의 입력을 콘솔에서 받는다.
        - 결과를 정해진 형식에 맞게 출력한다.

 */
public class IOManager {
    // 사용자의 입력을 받는 매서드
    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }
}
