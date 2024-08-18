package calculator;

public enum ArithmeticOperator {
    ADD("+"),
    SUB("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String arithmeticSymbol;

    ArithmeticOperator(String operator) {
        this.arithmeticSymbol = operator;
    }

    public String getArithmeticSymbol(){
        return arithmeticSymbol;
    }

    public static ArithmeticOperator getOperatorBySymbol(String operator){
        for (ArithmeticOperator ot : ArithmeticOperator.values()){
            if (ot.getArithmeticSymbol().equals(operator)){
                return ot;
            }
        }
        throw new UnsupportedOperationException("Выбранная операция недоступна");
    }
}
