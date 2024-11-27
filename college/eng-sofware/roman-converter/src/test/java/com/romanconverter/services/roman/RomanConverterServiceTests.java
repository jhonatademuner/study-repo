package com.romanconverter.services.roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanConverterServiceTests {

    private RomanConverterService romanConverterService;

    @BeforeEach
    void setUp() {
        romanConverterService = new RomanConverterService();
    }

    @Test
    void testValidRomanNumerals() {
        assertEquals("1", romanConverterService.romanToArabic("I"));
        assertEquals("4", romanConverterService.romanToArabic("IV"));
        assertEquals("9", romanConverterService.romanToArabic("IX"));
        assertEquals("40", romanConverterService.romanToArabic("XL"));
        assertEquals("90", romanConverterService.romanToArabic("XC"));
        assertEquals("400", romanConverterService.romanToArabic("CD"));
        assertEquals("900", romanConverterService.romanToArabic("CM"));
        assertEquals("58", romanConverterService.romanToArabic("LVIII"));
        assertEquals("1994", romanConverterService.romanToArabic("MCMXCIV"));
    }

    @Test
    void testLowercaseInput() {
        assertEquals("1", romanConverterService.romanToArabic("i"));
        assertEquals("4", romanConverterService.romanToArabic("iv"));
        assertEquals("58", romanConverterService.romanToArabic("lviii"));
        assertEquals("1994", romanConverterService.romanToArabic("mcmxciv"));
    }

    @Test
    void testInvalidRomanNumerals() {
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("IIII"));
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("VV"));
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("IC"));
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("ABC"));
    }

    @Test
    void testEmptyInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic(""));
        assertEquals("Input cannot be null or blank.", exception.getMessage());
    }

    @Test
    void testNullInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic(null));
        assertNotNull(exception.getMessage());
    }

    @Test
    void testSpacesInInput() {
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("M CM XC IV"));
    }

    @Test
    void testInvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("123"));
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("!@#"));
        assertThrows(IllegalArgumentException.class, () -> romanConverterService.romanToArabic("X*X"));
    }
}
