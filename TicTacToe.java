
package Lab1;

import java.util.Scanner;
public class TicTacToe {
        public static void main(String[] args) {
            
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Let's play TicTacToe -- X goes first");
        
        
        while (true) {
            game.printBoard();
            
            System.out.println("Enter coordinates to play your " + game.currentP);
            int row = input.nextInt();
            int column = input.nextInt();
            
            if (game.move(row, column)) {
                if (game.checkWin()) {
                    System.out.println(game.currentP + " wins!");
                    break;
                } else if (game.fullBoard()) {
                    System.out.println("It's a draw!");
                    break;
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("The location is occupied.");
            }
        }
  
        
        input.close();
    }
        

    private char[][] board;
    private char currentP;
    
    public TicTacToe() {
        board = new char[3][3];
        currentP = 'X';
        firstBoard();
    }
    
    public void firstBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    public void printBoard() {
        
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n");
        }
    }
    
    public boolean fullBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean move(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentP;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }
    
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }
        return false;
    }
    
        
    private boolean checkDiagonals() {
        return ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'));
    }
    
    
    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        return false;
    }
    

    public void switchPlayer() {
        if (currentP == 'X') {
            currentP = 'O';
        } else {
            currentP = 'X';
        }
    }
    
}


