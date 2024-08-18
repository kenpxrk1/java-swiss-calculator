package swissCalculator.calculator;

public enum ArithmeticOperator {
    ADD("+"), SUB("-"), MULTIPLY("*"), DIVIDE("/");

    private final String arithmeticSymbol;

    ArithmeticOperator(String operator) {
        this.arithmeticSymbol = operator;
    }

    public static ArithmeticOperator getOperatorBySymbol(String operator) {
        for (ArithmeticOperator ot : ArithmeticOperator.values()) {
            if (ot.getArithmeticSymbol().equals(operator)) {
                return ot;
            }
        }
        throw new UnsupportedOperationException("Выбранная операция недоступна");
    }

    public String getArithmeticSymbol() {
        return arithmeticSymbol;
    }
}
