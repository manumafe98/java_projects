package com.manumafe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class VowelsTest {
    
    @Test
    public void testMultipleVowels() {
        Vowels vowels = new Vowels("hello, world!");
        assertThat(vowels.getAmountOfVowels()).isEqualTo(3);
    }

    @Test
    public void testInvalidWord() {
        Vowels vowels = new Vowels("!%1235-?");
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> vowels.getAmountOfVowels())
            .withMessage("Invalid word");
    }

    @Test
    public void testNoVowelWord() {
        Vowels vowels = new Vowels("rhythm");
        assertThat(vowels.getAmountOfVowels()).isZero();
    }
}
