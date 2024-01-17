class Morse:
    """
        Converts a word into morse code, only alphabetic characters.
    """
    word: str = ""

    def __init__(self, input_word):
        self.morse_dict: dict[str, str] = {
            "a": ".-", "b": "-..", "c": "-.-.", "d": "-..", "e": ".", "f": "..-.", "g": "--.",
            "h": "....", "i": "..", "j": ".---", "k": "-.-", "l": ".-..", "m": "--", "n": "-.",
            "o": "---", "p": ".--.", "q": "--.-", "r": ".-.", "s": "...", "t": "-", "u": "..-",
            "v": "...-", "w": ".--", "x": "-..-", "y": "-.--", "z": "--.."
        }
        self.word = input_word.lower()

        if self.word == "":
            raise ValueError("Invalid word")

    def convert_to_morse(self) -> str:
        """Converter method

        Args:
            input_word (str): User inputted string

        Returns:
            str: morse converted string
        """
        result: str = ""

        for char in self.word:
            if char in self.morse_dict:
                result += self.morse_dict.get(char)
            else:
                raise ValueError("Word cannot contain numbers")
        
        return result


if __name__ == "__main__":
    user_input = input("Input the word you want to convert to morse code: ")
    morse = Morse(user_input)
    print(morse.convert_to_morse())
