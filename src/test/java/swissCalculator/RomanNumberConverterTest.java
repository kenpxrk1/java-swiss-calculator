package swissCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import swissCalculator.converter.impl.RomanNumbersConverter;

public class RomanNumberConverterTest {

    RomanNumbersConverter converter = new RomanNumbersConverter();

    @Test
    void convertToRoman_returnCorrect_leftBorder() {
        String roman = converter.arabicToRoman(1);
        Assertions.assertEquals(roman, "I");
    }

    @Test
    void convertToRoman_returnCorrect_rightBorder() {
        String roman = converter.arabicToRoman(100);
        Assertions.assertEquals(roman, "C");
    }

    @Test
    void convertToRoman_throwException_outOfRightBorder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String roman = converter.arabicToRoman(105);
        });
    }

    @Test
    void convertToRoman_throwException_outOfLeftBorder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String roman = converter.arabicToRoman(-4);
        });
    }
}
