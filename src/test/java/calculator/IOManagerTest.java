package calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class IOManagerTest {
    @AfterAll
    static void afterAll() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void input_입력() {
        // given
        IOManager ioManager = new IOManager();
        String testInput = "1,2,3\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes())); // 입력값 세팅

        // when
        String result = ioManager.input();

        // then
        assertEquals("1,2,3", result);
    }

    @Test
    void printResult_정수_출력() {
        // given
        IOManager ioManager = new IOManager();
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput)); // 출력을 콘솔이 아닌 testOutput에 기록

        // when
        ioManager.printResult(2.0);

        // then
        String result = testOutput.toString().trim(); // "\n"때문에 trim() 사용
        assertEquals("결과 : 2", result);
    }

    @Test
    void printResult_실수_출력() {
        // given
        IOManager ioManager = new IOManager();
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        // when
        ioManager.printResult(2.1);

        // then
        String result = testOutput.toString().trim();
        assertEquals("결과 : 2.100000", result);
    }
}