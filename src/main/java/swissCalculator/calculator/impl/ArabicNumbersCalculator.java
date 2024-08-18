package swissCalculator.calculator.impl;

import swissCalculator.calculator.Calculator;

public class ArabicNumbersCalculator implements Calculator {

    @Override
    public String add(String a, String b) {
        return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
    }

    @Override
    public String sub(String a, String b) {
        return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
    }

    @Override
    public String multiply(String a, String b) {
        return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
    }

    @Override
    public String divide(String a, String b) {
        return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
    }
}
