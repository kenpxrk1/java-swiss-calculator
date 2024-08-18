package swissCalculator.calculator;

public class CalculatorService {
    private static final InputValidator validator = new InputValidator();

    private String delegateOperation(ArithmeticOperator operator, String first, String second, Calculator calculator) {
        String result;
        switch (operator) {
            case ADD:
                result = calculator.add(first, second);
                System.out.println(result);
                return result;
            case SUB:
                result = calculator.sub(first, second);
                System.out.println(result);
                return result;
            case DIVIDE:
                result = calculator.divide(first, second);
                System.out.println(result);
                return result;
            case MULTIPLY:
                result = calculator.multiply(first, second);
                System.out.println(result);
                return result;
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
    }

    public String handleOperation(String userInput) {
        String[] args = userInput.split(" ");
        validator.validateInput(args);
        String first = args[0];
        String second = args[2];
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.getOperatorBySymbol(args[1]);
        Calculator calculator = CalculatorFactory.getCalculator(validator.getCalculatorType(first, second));
        return delegateOperation(arithmeticOperator, first, second, calculator);
    }
}
