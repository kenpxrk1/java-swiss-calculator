package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorManagerTest {
    CalculatorManager manager = new CalculatorManager();

    @Test
    void calculateAdd_returnCorrectAnswer_correctArabicNumbers(){
        String testCase = "1 + 7";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("8", result);
    }

    @Test
    void calculateAdd_returnCorrectAnswer_correctRomanNumbers(){
        String testCase = "I + IV";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("V", result);
    }

    @Test
    void calculateSub_returnCorrectAnswer_correctRomanNumbers(){
        String testCase = "V - IV";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("I", result);
    }

    @Test
    void calculateSub_returnCorrectAnswer_correctArabicNumbers(){
        String testCase = "9 - 2";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("7", result);
    }

    @Test
    void calculateDivide_returnCorrectAnswer_correctRomanNumbers(){
        String testCase = "VI / II";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("III", result);
    }

    @Test
    void calculateDivide_returnCorrectAnswer_correctArabicNumbers(){
        String testCase = "9 / 3";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("3", result);
    }

    @Test
    void calculateMultiply_returnCorrectAnswer_correctArabicNumbers(){
        String testCase = "5 * 4";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("20", result);
    }

    @Test
    void calculateMultiply_returnCorrectAnswer_correctRomanNumbers(){
        String testCase = "IV * IV";
        String result = manager.operationsHandler(testCase);
        Assertions.assertEquals("XVI", result);
    }

    @Test
    void calculate_throwException_romanNumbersHigherTen(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "I + XV";
            String result = manager.operationsHandler(testCase);
        });
    }

    @Test
    void calculate_throwException_arabicNumbersHigherTen(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "20 * 1";
            String result = manager.operationsHandler(testCase);
        });
    }

    @Test
    void calculate_throwException_arabicNumbersLowerOne(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "-I * IV";
            String result = manager.operationsHandler(testCase);
        });
    }

    @Test
    void calculate_throwException_invalidOperator(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "I : IV";
            String result = manager.operationsHandler(testCase);
        });
    }

    @Test
    void calculate_throwException_invalidInputLength(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "I : IV + X";
            String result = manager.operationsHandler(testCase);
        });
    }

    @Test
    void calculate_throwException_invalidOperands(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String testCase = "[ * PIVO";
            String result = manager.operationsHandler(testCase);
        });
    }
}
