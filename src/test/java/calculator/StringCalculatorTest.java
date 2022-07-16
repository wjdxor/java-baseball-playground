package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;


public class StringCalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    void add_test() {
        String input = "2 + 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(calculator.inputStringCalculator()).isEqualTo(5);
    }

    @Test
    void String_test() {
        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(calculator.inputStringCalculator()).isEqualTo(10);
    }

    @Test
    void 입력에러_테스트() {
        assertThatThrownBy(() ->
                calculator.inputStringCalculator())
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 나누기_에러_테스트() {
        String input = "3 / 0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() ->
                calculator.inputStringCalculator())
                .isInstanceOf(ArithmeticException.class);
    }
}
