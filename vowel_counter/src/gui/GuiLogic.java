package gui;

public class GuiLogic {
    public long checkAmountOfVowels(String word) {
        return word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "aeiouAEIOU".contains(String.valueOf(ch)))
                .count();
    }
}
