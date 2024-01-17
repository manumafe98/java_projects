package com.manumafe;

public class Vowels {
    private String word;
    private final String regex = "[^a-zA-Z]";

    Vowels(String word) {
        this.word = word.replaceAll(regex, "");
    }

    public long getAmountOfVowels() {
        if (word.equals("")) {
            throw new IllegalArgumentException("Invalid word");
        }

        return word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "aeiouAEIOU".contains(String.valueOf(ch)))
                .count();
    }
}
