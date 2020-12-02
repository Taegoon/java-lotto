package my.project.cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-20 오전 9:30
 * Developer : Seo
 */
class StringPlusCalculatorTest {
    private StringPlusCalculator spc;

    @BeforeEach
    void setUp() {
        spc = new StringPlusCalculator();
    }

    @DisplayName("null 값을 입력할 경우 0을 반환해야 한다")
    @ParameterizedTest
    @NullSource
    void givenNull_thenReturnZero(String input) {
        assertThat(spc.sumStringByDelimiter(input)).isZero();
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다")
    @ParameterizedTest
    @EmptySource
    void givenEmpty_thenReturnZero(String input) {
        assertThat(spc.sumStringByDelimiter(input)).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void givenStringOne_thenReturnSelf(String input) {
        assertThat(spc.sumStringByDelimiter(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3"}, delimiter = '|')
    void givenSingleDelimiter_thenReturnSum(String input, int expected) {
        assertThat(spc.sumStringByDelimiter(input)).isEqualTo(expected);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6"}, delimiter = '|')
    void givenMultiDelimiter_thenReturnSum(String input, int expected) {
        assertThat(spc.sumStringByDelimiter(input)).isEqualTo(expected);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    void givenCustomDelimiter_thenReturnSum() {
        assertThat(spc.sumStringByDelimiter("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    @Test
    void givenNegative_thenThrowException() {
        assertThatThrownBy(() -> spc.sumStringByDelimiter("-1,2:3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("0 혹은 음수가 포함되어 있습니다.")
                .hasStackTraceContaining("CalException");
    }

    @DisplayName("통합")
    @ParameterizedTest
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    void givenString_thenReturnSum(String input, int expected) {
        assertThat(spc.sumStringByDelimiter(input)).isEqualTo(expected);
    }

}