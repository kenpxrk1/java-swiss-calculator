package calculator;

public class RomanNumbersCalculator implements Calculator {
        @Override
        public String add(String a, String b) {
            int num1 = RomanNumbersConverter.romanToArabic(a);
            int num2 = RomanNumbersConverter.romanToArabic(b);
            return RomanNumbersConverter.arabicToRoman(num1 + num2);
        }

        @Override
        public String sub(String a, String b) {
            int num1 = RomanNumbersConverter.romanToArabic(a);
            int num2 = RomanNumbersConverter.romanToArabic(b);
            return RomanNumbersConverter.arabicToRoman(num1 - num2);
        }

        @Override
        public String multiply(String a, String b) {
            int num1 = RomanNumbersConverter.romanToArabic(a);
            int num2 = RomanNumbersConverter.romanToArabic(b);
            return RomanNumbersConverter.arabicToRoman(num1 * num2);
        }

        @Override
        public String divide(String a, String b) {
            int num1 = RomanNumbersConverter.romanToArabic(a);
            int num2 = RomanNumbersConverter.romanToArabic(b);
            return RomanNumbersConverter.arabicToRoman(num1 / num2);
        }
    }

