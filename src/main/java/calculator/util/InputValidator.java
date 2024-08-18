package calculator.util;

import calculator.ArithmeticOperator;
import calculator.CalculatorType;
import calculator.RomanNumbersConverter;

public class InputValidator {
    private static boolean isCorrectRoman(String romanNumber) {
        int convertedArabic = RomanNumbersConverter.romanToArabic(romanNumber);
        if (convertedArabic > 10 || convertedArabic < 1) {
            throw new IllegalArgumentException("Incorrect number: " + romanNumber);
        }
        return true;
    }

    private boolean isCorrectArabic(String arabicNumber) {
        try {
            int convertedArabic = Integer.parseInt(arabicNumber);
            if (convertedArabic > 10 || convertedArabic < 1) {
                throw new IllegalArgumentException("Incorrect number: " + arabicNumber);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isCorrectOperandTypes(String operand1, String operand2) {
        return ((isCorrectArabic(operand1) && isCorrectArabic(operand2)) || (isCorrectRoman(operand1) && isCorrectRoman(operand2)));
    }

    public CalculatorType getCalculatorType(String operand1, String operand2) {
        if (isCorrectArabic(operand1) && isCorrectArabic(operand2)) {
            return CalculatorType.ARABIC;
        } else if (isCorrectRoman(operand1) && isCorrectRoman(operand2)) {
            return CalculatorType.ROMAN;
        }
        return null;
    }

    private boolean isCorrectInputLength(String[] args) {
        return args.length == 3;
    }

    private boolean isCorrectOperator(String operatorValue) {
        for (ArithmeticOperator operatorType : ArithmeticOperator.values()) {
            if (operatorType.getArithmeticSymbol().equals(operatorValue)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Введен некорректный оператор");
    }

    public void validateInput(String[] args) {
        if (!isCorrectInputLength(args)) {
            throw new IllegalArgumentException("Команда введена некорректно");
        }

        String leftOperand = args[0];
        String rightOperand = args[2];
        String operator = args[1];

        if (!isCorrectOperator(operator)) {
            throw new IllegalArgumentException("Некорректный оператор");
        }

        if (!isCorrectOperandTypes(leftOperand, rightOperand)) {
            throw new IllegalArgumentException("Некорректные операнды");
        }
    }
}
