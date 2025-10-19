package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberExtractorTest {

    private final NumberExtractor extractor = new NumberExtractor();

    @Test
    void 음수_입력_예외_테스트() {
        assertThatThrownBy(() -> extractor.extractNumber("-1,2,3", List.of(",", ":")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력");
    }

    @Test
    void 커스텀_구분자_2글자이상_예외_테스트() {
        assertThatThrownBy(() -> extractor.extractNumber("//dd\n1dd2dd3", List.of(",", ":")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력");
    }

    @Test
    void 숫자_아닌_문자_예외_테스트() {
        assertThatThrownBy(() -> extractor.extractNumber("1,a,3", List.of(",", ":")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력");
    }
}