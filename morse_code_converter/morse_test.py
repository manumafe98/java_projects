import unittest

from morse import (
    Morse,
)


class MorseTest(unittest.TestCase):
    def test_morse_word_test(self):
        self.assertEqual(Morse("test").convert_to_morse(), "-....-")
    
    def test_uppercase_word(self):
        self.assertEqual(Morse("TEST").convert_to_morse(), "-....-")


class InvalidWordTest(unittest.TestCase):
    def test_invalid_word(self):
        with self.assertRaises(ValueError) as err:
            Morse("")
        self.assertEqual(type(err.exception), ValueError)
        self.assertEqual(
            err.exception.args[0],
            "Invalid word",
        )
    
    def test_invalid_word_contains_numbers(self):
        with self.assertRaises(ValueError) as err:
            Morse("test1").convert_to_morse()
        self.assertEqual(type(err.exception), ValueError)
        self.assertEqual(
            err.exception.args[0],
            "Word cannot contain numbers",
        )


if __name__ == '__main__':
    unittest.main()
