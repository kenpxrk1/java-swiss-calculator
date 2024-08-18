package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArabicNumbersCalculatorTest {
    private static final ArabicNumbersCalculator calculator = new ArabicNumbersCalculator();

    @Test
    void addTwoPositiveNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.add("1", "9"));
        Assertions.assertEquals(res, 10);
    }

    @Test
    void addTwoPositiveNumbers_throwsException_StringArg() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            int res = Integer.parseInt(calculator.add("b", "4"));
        });
    }

    @Test
    void subTwoPositiveNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.sub("9", "1"));
        Assertions.assertEquals(res, 8);
    }

    @Test
    void subTwoPositiveNumbers_returnCorrectNegativeAns() {
        int res = Integer.parseInt(calculator.sub("1", "9"));
        Assertions.assertEquals(res, -8);
    }

    @Test
    void multiplyTwoPositiveNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.multiply("3", "9"));
        Assertions.assertEquals(res, 27);
    }

    @Test
    void multiplyPositiveAndNegativeNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.multiply("-3", "9"));
        Assertions.assertEquals(res, -27);
    }

    @Test
    void dividePositiveNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.divide("6", "3"));
        Assertions.assertEquals(res, 2);
    }

    @Test
    void dividePositiveAndNegativeNumbers_returnCorrectAns() {
        int res = Integer.parseInt(calculator.divide("6", "-3"));
        Assertions.assertEquals(res, -2);
    }

    @Test
    void divideByZero_throwsArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int res = Integer.parseInt(calculator.divide("6", "0"));
        });
    }
}
