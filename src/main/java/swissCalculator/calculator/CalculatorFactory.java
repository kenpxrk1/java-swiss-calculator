package swissCalculator.calculator;

import swissCalculator.calculator.impl.ArabicNumbersCalculator;
import swissCalculator.calculator.impl.RomanNumbersCalculator;

public class CalculatorFactory {
    public static Calculator getCalculator(CalculatorType calcType) {
        switch (calcType) {
            case ARABIC:
                return new ArabicNumbersCalculator();
            case ROMAN:
                return new RomanNumbersCalculator();
            default:
                throw new UnsupportedOperationException("Такого калькулятора не существует");
        }
    }
}
