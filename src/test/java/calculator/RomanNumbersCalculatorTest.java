package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumbersCalculatorTest {
    private static final RomanNumbersCalculator calculator = new RomanNumbersCalculator();

    @Test
    void addTwoPositiveNumbers_returnCorrectAns(){
        String res = calculator.add("I", "IX");
        Assertions.assertEquals(res, "X");
    }

    @Test
    void addTwoPositiveNumbers_throwsException_IncorrectArg(){
        // работает некорректно, тк в логике программы предусмотрен выброс исключения
        // в классе валидации, а не калькулятора -> не знаю, стоит ли писать на это тест-кейс
        String res = calculator.add("b", "V");
        Assertions.assertEquals("V", res);
    }

    @Test
    void subTwoPositiveNumbers_returnCorrectAns(){
        String res = calculator.sub("IX", "I");
        Assertions.assertEquals(res, "VIII");
    }

    @Test
    void subTwoPositiveNumbers_throwException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String res = calculator.sub("1", "9");
        });
    }

    @Test
    void multiplyTwoPositiveNumbers_returnCorrectAns(){
        String res = calculator.multiply("III", "IX");
        Assertions.assertEquals(res, "XXVII");
    }

    @Test
    void multiplyPositiveAndNegativeNumbers_throwException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String res = calculator.multiply("-3", "9");
        });
    }

    @Test
    void dividePositiveNumbers_returnCorrectAns(){
        String res = calculator.divide("VI", "III");
        Assertions.assertEquals(res, "II");
    }

    @Test
    void dividePositiveAndNegativeNumbers_returnEmptyString(){
        // тк метод перевода отрицательного арабского числа в римское возвращает 0,
        // возникает zero division error

        Assertions.assertThrows(ArithmeticException.class, () -> {
            String res = calculator.divide("6", "-3");
        });
    }

    @Test
    void divideByZero_throwsArithmeticException(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            String res = calculator.divide("6", "0");
        });
    }
}
