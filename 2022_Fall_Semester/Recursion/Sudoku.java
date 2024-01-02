import java.util.Arrays;

public class Sudoku {

    public static boolean solve(int[][] board, int row, int column){

        if(column == 9){
            return solve(board, row + 1, 0);
        }

        if(row == 9){
            return true;
        }

        if(board[row][column] != 0){
            return solve(board, row, column + 1);
        } 
        for(int number = 1; number <= 9; number++){
            if(valid(board, row, column, number)){
                board[row][column] = number;
                if(solve(board, row, column + 1) == true){
                    return true;
                }
                board[row][column] = 0;
            }
        }     
        return false;
    } 
    
    public static boolean valid(int[][] board, int row, int column, int number){

        for(int c = 0; c < 9; c++){ // Horizontal
            if(board[row][c] == number){
                return false;
            }
        }

        for(int r = 0; r < 9; r++){ // Vertical
            if(board[r][column] == number){
                return false;
            }
        }
        
        
        for(int rGrid = gridPosition(row); rGrid <= gridPosition(row)+2; rGrid++){ // 3x3
            for(int cGrid = gridPosition(column); cGrid <= gridPosition(column)+2; cGrid++){
                if(board[rGrid][cGrid] == number){
                    return false;
                }
            }
        }
        
        return true;
    }

    public static int gridPosition(int point){

        if(point <= 2){
            return 0;
        } else if(point <= 5 && point >= 3){
            return 3;
        } else{
            return 6;
        }
    }

     public static void boardToString(int[][] sudoku){
        String sudokuBoard = Arrays.deepToString(sudoku).replace("], ", "\n").replace("[","").replace(","," ");
        sudokuBoard = sudokuBoard.substring(0, sudokuBoard.length() - 2);
        System.out.println(sudokuBoard);
    }



    public static void main(String[] args) {
        int[][] sudoku = {  {0,0,3,0,2,0,6,0,0}, {9,0,0,3,0,5,0,0,1}, {0,0,1,8,0,6,4,0,0}, 
                            {0,0,8,1,0,2,9,0,0}, {7,0,0,0,0,0,0,0,8}, {0,0,6,7,0,8,2,0,0},
                            {0,0,2,6,0,9,5,0,0}, {8,0,0,2,0,3,0,0,9}, {0,0,5,0,1,0,3,0,0}   } ;
        boardToString(sudoku);
        solve(sudoku, 0, 0);
        System.out.println();
        boardToString(sudoku);
    }
}
