package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumberConverterTest {

    @Test
    void convertToRoman_returnCorrect_leftBorder(){
        String roman = RomanNumbersConverter.arabicToRoman(1);
        Assertions.assertEquals(roman, "I");
    }

    @Test
    void convertToRoman_returnCorrect_rightBorder(){
        String roman = RomanNumbersConverter.arabicToRoman(100);
        Assertions.assertEquals(roman, "C");
    }

    @Test
    void convertToRoman_throwException_outOfRightBorder(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String roman = RomanNumbersConverter.arabicToRoman(105);
        });
    }

    @Test
    void convertToRoman_throwException_outOfLeftBorder(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String roman = RomanNumbersConverter.arabicToRoman(-4);
        });
    }
}
