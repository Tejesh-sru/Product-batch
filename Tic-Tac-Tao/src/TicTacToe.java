import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void startGame(String player1, String player2) {
        Scanner sc = new Scanner(System.in);
        char currentSymbol = 'X';
        String currentPlayer = player1;
        int moves = 0;
        while (true) {
            printBoard();
            System.out.println();
            System.out.println(currentPlayer + "'s turn (" + currentSymbol + ")");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position. Try again.");
                continue;
            }
            if (board[row][col] != '-') {
                System.out.println("This position is already filled.");
                continue;
            }
            board[row][col] = currentSymbol;
            moves++;
            if (checkWinner(currentSymbol)) {
                printBoard();
                System.out.println();
                System.out.println("Congratulations " + currentPlayer + "!");
                System.out.println("You won the game!");
                break;
            }
            if (moves == 9) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }
            if (currentSymbol == 'X') {
                currentSymbol = 'O';
                currentPlayer = player2;
            } else {
                currentSymbol = 'X';
                currentPlayer = player1;
            }
        }
    }
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++){
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }
        
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }
        return false;
    }
}