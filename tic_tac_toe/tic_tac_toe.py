class TicTacToe:
    """
        Generate a class of the famous Tic Tac Toe game
    """

    def print_chart(self, board: list[list[str]]) -> None:
        """Prints the chart in the console with the corresponding progress.
        Args:
            board (list[list[str]]): bidimensional array that represents the game chart
        
        Returns:
            None
        """
        chart = f"""
         {board[0, 0]} | {board[0, 1]} | {board[0, 2]} 
        -----------
         {board[1, 0]} | {board[1, 1]} | {board[1, 2]}
        -----------
         {board[2, 0]} | {board[2, 1]} | {board[2, 2]}      
        """
        print(chart)


    def is_position_valid(self, board : list[list[str]], row: int, column: int) -> bool:
        """Checks if the position the player is entering is valid or is already taken.

        Args:
            board  (list[list[str]]): bidimensional array that represents the game chart
            row    (int): The row where you want to place your character
            column (int): The column where you want to place your character

        Returns:
            bool: Returns true or false depending if the position is taken.
        """
        if board[row, column] == "X" or board[row, column] == "O":
            return False
        
        return True

    def check_columns(self, board: list[list[str]]) -> bool:
        """Check if the winning conditions of the game are matched.

        Args:
            board (list[list[str]]): bidimensional array that represents the game chart

        Returns:
            bool: Returns True if the columns have all the same char.
        """
        for cols in range(3):
            if board[0][cols] == board[1][cols] == board[2][cols] != " ":
                return True
        
        return False
    
    def check_rows(self, board: list[list[str]]) -> bool:
        """Check if the winning conditions of the game are matched.

        Args:
            board (list[list[str]]): bidimensional array that represents the game chart

        Returns:
            bool: Returns True if the rows have all the same char.
        """
        for rows in range(3):
            if board[rows][0] == board[rows][1] == board[rows][2] != " ":
                return True
        
        return False
    
    def check_diagonals(self, board: list[list[str]]) -> bool:
        """Check if the winning conditions of the game are matched.

        Args:
            board (list[list[str]]): bidimensional array that represents the game chart

        Returns:
            bool: Returns True if the diagonals have all the same char.
        """
        if board[0][0] == board[1][1] == board[2][2] != " " or board[0][2] == board[1][1] == board[2][0] != " ":
            return True
        
        return False


    def check_win(self, board: list[list[str]]) -> bool:
        """Check if the winning conditions of the game are matched.

        Args:
            board (list[list[str]]): bidimensional array that represents the game chart

        Returns:
            bool: Uses the check_diagonals/rows/columns to validate if it is a winner.
        """
        if self.check_columns(board) or self.check_rows(board) or self.check_diagonals(board):
            return True
        
        return False
