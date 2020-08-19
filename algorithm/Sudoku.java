package algorithm;

import java.util.Arrays;

public class Sudoku {



    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10]; //dictionary to know if there is a number already in the row
        boolean[][] col = new boolean[10][10]; //dictionary to know if a number 0-9 exists in the current column.
        boolean[][] box = new boolean[10][10]; //dictionary to know if a number 0-9 exists in the current 3x3 box.
        //Reason for dictionary above, it is a O{1) operation to know if you can safely insert a number in the current row, if it is not safe.

        for (int i = 0; i < 9; i++) {//fill the dictionaries above with the numbers we got from the board[][] input.
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row[i][board[i][j] - '0'] = true;
                    col[j][board[i][j] - '0'] = true;
                    int b = (i / 3) * 3 + (j / 3);
                    box[b][board[i][j] - '0'] = true;
                }
            }
        }
        doDfs(row, col, box, board, 0, 0);
    }

    public boolean doDfs(boolean[][] row, boolean[][] col, boolean[][] box, char[][] board, int x, int y) {
        //If we reached this index in the matrix then we have filled the sudoku successfully.
        if (x == 8 && y == 9) {
            return true;
        } else if (y == 9) {
            y = 0;
            x += 1;
        }
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {//try all 9 numbers to be inserted in this current cell while backtracking.
                if (isValid(row, col, box, i, x, y)) {
                    row[x][i] = true;
                    col[y][i] = true;
                    int b = ((x / 3) * 3) + (y / 3);
                    box[b][i] = true;
                    board[x][y] = (char)( i + '0');
                    if (doDfs(row, col, box, board, x, y + 1)) {
                        return true;
                    }
                    board[x][y] = '.';
                    row[x][i] = false;
                    col[y][i] = false;
                    box[b][i] = false;
                }
            }
        } else {
            return doDfs(row, col, box, board, x, y + 1);
        }
        return false;
    }

    //Checks if the number i is safe to be inserted in the row/col/3x3 box in O(1) operation.
    public boolean isValid(boolean[][] row, boolean[][] col, boolean[][] box, int i, int x, int y) {
        if (row[x][i]) {
            return false;
        }
        if (col[y][i]) {
            return false;
        }
        int b = ((x / 3) * 3) + (y / 3); // formula to get the 3x3 box and all 9 elements in it.
        if (box[b][i]) {
            return false;
        }
        return true;
    }

    public boolean checkValidSoduku(char[][] board) {

        // (1,1) (1,4) (1,7)
        // (4,1) (4,4) (4,7)
        // (7,1) (7,4) (7,7)

        boolean[] checkValidation = new boolean[9];

        for (int i = 1; i < 9; i = i + 3) {
            for (int j = 1; j < 9; j = j + 3) {
                checkValidation[board[i-1][j-1] - 48] = true;
                checkValidation[board[i-1][j] - 48] = true;
                checkValidation[board[i-1][j+1]- 48] = true;
                checkValidation[board[i][j-1]- 48] = true;
                checkValidation[board[i][j]- 48] = true;
                checkValidation[board[i][j+1]- 48] = true;
                checkValidation[board[i+1][j-1]- 48] = true;
                checkValidation[board[i+1][j]- 48] = true;
                checkValidation[board[i+1][j+1]- 48] = true;
            }
        }

        for(boolean b : checkValidation) {
            if(!b) {
                return false;
            }
        }

        return true;

    }

    boolean[] checkDuplication = new boolean[10];

    public void reSetDuplicationVector(){
        for (int i= 1; i < 10; i++) {
            checkDuplication[i] = false;
        }
    }

    public boolean tag(char c) {
        if (c == '.') {
            return true;
        }

        int charValue = c - 48; //48 '.'
        if (checkDuplication[charValue]) {
            return false;
        } else {
            checkDuplication[charValue] = true;
            return true;
        }
    }

    public boolean isValidSudoku(char[][] board) {

        //check rows
        for (int i = 0; i < 9; i = i + 1) {
            reSetDuplicationVector();
            for (int j = 0; j < 9; j = j + 1) {
                if (!tag(board[i][j])) {
                    return false;
                }
            }
        }

        // check colums
        for (int i = 0; i < 9; i = i + 1) {
            reSetDuplicationVector();
            for (int j = 0; j < 9; j = j + 1) {
                if (!tag(board[j][i])) {
                    return false;
                }
            }
        }

        for(int i = 0 ; i < 9; i++) {
            reSetDuplicationVector();
            for (int j = 0; j < 9; j = j + 1) {
                if (!tag(board[(i/3)*3+(j/3)][(i%3)*3+(j%3)])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {


        Sudoku sudoku = new Sudoku();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        sudoku.isValidSudoku(board);

        System.out.println((char)'.');
        System.out.println((int)'.'); // 46
        System.out.println((int)'0'); // 48
        System.out.println((int)'1'); // 48
        System.out.println((int)'9');


        sudoku.solveSudoku(board);
    }
}
