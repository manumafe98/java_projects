import unittest

from tic_tac_toe import (
    TicTacToe,
)

class TicTacToeTest(unittest.TestCase):
    def testXWinByUpperRow(self):
        self.assertEqual(
            TicTacToe().check_win([["X", "X", "X"], ["O", "O", " "], [" ", " ", " "]]), True
        )
    
    def testXWinByRaisingDiagonal(self):
        self.assertEqual(
            TicTacToe().check_win([[" ", "O", "X"], ["O", "X", " "], ["X", " ", " "]]), True
        )

    def testXWinByLeftColumn(self):
        self.assertEqual(
            TicTacToe().check_win([["X", "O", " "], ["X", "O", " "], ["X", " ", " "]]), True
        )        

if __name__ == '__main__':
    unittest.main()
