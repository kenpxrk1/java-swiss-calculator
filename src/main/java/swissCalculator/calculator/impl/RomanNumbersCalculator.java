package swissCalculator.calculator.impl;

import swissCalculator.converter.impl.RomanNumbersConverter;
import swissCalculator.calculator.Calculator;

public class RomanNumbersCalculator implements Calculator {
    private static final RomanNumbersConverter converter = new RomanNumbersConverter();

    @Override
    public String add(String a, String b) {
        int firstNum = converter.romanToArabic(a);
        int secondNum = converter.romanToArabic(b);
        return converter.arabicToRoman(firstNum + secondNum);
    }

    @Override
    public String sub(String a, String b) {
        int firstNum = converter.romanToArabic(a);
        int secondNum = converter.romanToArabic(b);
        return converter.arabicToRoman(firstNum - secondNum);
    }

    @Override
    public String multiply(String a, String b) {
        int firstNum = converter.romanToArabic(a);
        int secondNum = converter.romanToArabic(b);
        return converter.arabicToRoman(firstNum * secondNum);
    }

    @Override
    public String divide(String a, String b) {
        int firstNum = converter.romanToArabic(a);
        int secondNum = converter.romanToArabic(b);
        return converter.arabicToRoman(firstNum / secondNum);
    }
}

