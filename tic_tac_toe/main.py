import numpy as np
from tic_tac_toe import TicTacToe

array: list[list[str]] = np.array([[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]])
game_is_on: bool = True
count: int = 0
player: str = ""


while game_is_on:
    tic_tac_toe = TicTacToe()
    tic_tac_toe.print_chart(array)

    if " " not in array:
        # Checks for blank spaces in the array and if there are not.
        # And there is no winner already its a tie.
        print("It's a tie!")
        game_is_on = False
        break

    if count % 2 == 0:
        # Indicates which player should play.
        player = "X"
    else:
        player = "O"

    position_valid: bool = False
    while not position_valid:
        position = input(f"{player} turn, enter the row and column: ")
        row, col = int(position[0]), int(position[1])
        if tic_tac_toe.is_position_valid(array, row, col):
            array[row, col] = player
            position_valid = True
        else:
            print("Please enter a valid position. That one is already occupied.")

    winner = tic_tac_toe.check_win(array)
    if winner:
        tic_tac_toe.print_chart(array)
        print(f"{player} wins!")
        game_is_on = False

    count += 1
