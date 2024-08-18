package swissCalculator.calculator;

import swissCalculator.converter.impl.RomanNumbersConverter;

public class InputValidator {

    private static final RomanNumbersConverter converter = new RomanNumbersConverter();

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

        if (!isCorrectOperandType(leftOperand, rightOperand)) {
            throw new IllegalArgumentException("Некорректные операнды");
        }
    }

    public CalculatorType getCalculatorType(String operand1, String operand2) {
        if (isCorrectArabic(operand1) && isCorrectArabic(operand2)) {
            return CalculatorType.ARABIC;
        } else if (isCorrectRoman(operand1) && isCorrectRoman(operand2)) {
            return CalculatorType.ROMAN;
        }
        return null;
    }

    private boolean isCorrectRoman(String romanNumber) {
        int convertedArabic = converter.romanToArabic(romanNumber);
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

    private boolean isCorrectOperandType(String operand1, String operand2) {
        return ((isCorrectArabic(operand1) && isCorrectArabic(operand2)) || (isCorrectRoman(operand1) && isCorrectRoman(operand2)));
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
}
