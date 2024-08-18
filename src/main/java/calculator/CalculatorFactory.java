package calculator;

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
