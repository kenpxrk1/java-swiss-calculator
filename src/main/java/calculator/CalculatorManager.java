package calculator;

import calculator.util.InputValidator;

public class CalculatorManager {
    private static final InputValidator VALIDATOR = new InputValidator();

    public String operationsHandler(String userInput){
        String[] args = userInput.split(" ");
        VALIDATOR.validateInput(args);
        String operand1 = args[0];
        String operand2 = args[2];
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.getOperatorBySymbol(args[1]);
        Calculator calculator = CalculatorFactory.getCalculator(VALIDATOR.getCalculatorType(operand1, operand2));
        String result;
        switch (arithmeticOperator){
            case ADD:
                result = calculator.add(operand1, operand2);
                System.out.println(result);
                return result;
            case SUB:
                result = calculator.sub(operand1, operand2);
                System.out.println(result);
                return result;
            case DIVIDE:
                result = calculator.divide(operand1, operand2);
                System.out.println(result);
                return result;
            case MULTIPLY:
                result = calculator.multiply(operand1, operand2);
                System.out.println(result);
                return result;
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
    }
    }
