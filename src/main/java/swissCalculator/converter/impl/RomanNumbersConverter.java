package swissCalculator.converter.impl;

import swissCalculator.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbersConverter implements Converter {

    private static final Map<Character, Integer> ROMAN_NUMBERS_MAP = new HashMap() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static final String[] ROMAN_NUMBERS = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMBERS = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romanToArabic(String romanNum) {
        try {
            int result = 0;
            int prevValue = 0;

            for (int i = romanNum.length() - 1; i >= 0; i--) {
                int curValue = ROMAN_NUMBERS_MAP.get(romanNum.charAt(i));

                if (curValue < prevValue) {
                    result -= curValue;
                } else {
                    result += curValue;
                }

                prevValue = curValue;
            }
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    public String arabicToRoman(int arabicNum) {
        if (arabicNum > 100 || arabicNum < 1) {
            throw new IllegalArgumentException("Number out of range");
        }
        StringBuilder convertedRoman = new StringBuilder();
        for (int i = 0; i < ROMAN_NUMBERS.length; i++) {
            while (arabicNum >= ARABIC_NUMBERS[i]) {
                convertedRoman.append(ROMAN_NUMBERS[i]);
                arabicNum -= ARABIC_NUMBERS[i];
            }
        }
        return convertedRoman.toString();
    }
}
