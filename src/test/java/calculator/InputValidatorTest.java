package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import calculator.util.InputValidator;

public class InputValidatorTest {
    InputValidator validator = new InputValidator();

    @Test
    void getCalculatorType_returnCorrectType_romanOperands(){
        CalculatorType calculatorType = validator.getCalculatorType("VII", "IX");
        Assertions.assertEquals(CalculatorType.ROMAN, calculatorType);
    }

    @Test
    void getCalculatorType_returnCorrectType_arabicOperands(){
        CalculatorType calculatorType = validator.getCalculatorType("5", "3");
        Assertions.assertEquals(CalculatorType.ARABIC, calculatorType);
    }

    @Test
    void getCalculatorType_throwsException_mixedOperands(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CalculatorType calculatorType = validator.getCalculatorType("V", "3");
        });
    }

    @Test
    void validateInput_void_correctInputArabic(){
        String[] input = {"1", "*", "3"};
        Assertions.assertDoesNotThrow(() -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_void_correctInputRoman() {
        String[] input = {"IV", "+", "IX"};
        Assertions.assertDoesNotThrow(() -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_mixedOperands(){
        String[] input = {"IV", "+", "5"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_incorrectOperator(){
        String[] input = {"IV", "'", "V"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_incorrectDataLength(){
        String[] input = {"IV", "'", "V", "-"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_incorrectOperands(){
        String[] input = {"IV", "+", "PIVO"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_operandsHigherThanTen(){
        String[] input = {"IV", "+", "XII"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }

    @Test
    void validateInput_throwsException_operandsLowerThanOne() {
        String[] input = {"9", "*", "-3"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            validator.validateInput(input);
        });
    }
}
