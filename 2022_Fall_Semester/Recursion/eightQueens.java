import java.util.Arrays;

public class eightQueens {

    public static boolean solve(int[][] board, int column){

        if(column == 8){
            return true;
        }
        for(int row = 0; row < 8; row++){
            if(valid(board, row, column)){
                board[row][column] = 1;
                if(solve(board, column + 1) == true){
                    return true;
                }
                else{
                    board[row][column] = 0;
                }
            }
        }

        
        return false;
    }

    //chess[row][column] 1-7
    public static boolean valid(int[][] board, int row, int column){
        if(column == 0){
            return true;
        }

        for(int c = column; c >= 0; c--){ // Queens in Row (To the Left)
            if(board[row][c] == 1){
                return false;
            }
        }

        int diagonal = row - column; // Queens in Diagonal (Upper Left Diagonal)
        for(int r = row; r >= 0; r--){
            for(int c = column; c >= 0; c--){
                if((r-c) == diagonal){
                    if(board[r][c] == 1){
                        return false;
                    }
                }
            }
        }

        int rowTemp = row; // Queens in Diagonal (Lower Left Diagonal)
        int columnTemp = column;
        for(int r = row; r <= 7; r++ ){
            for(int c = column; c >= 0; c--){
                if(r == rowTemp && c == columnTemp){
                        rowTemp++;
                        columnTemp--;
                    if(board[r][c] == 1){
                        return false;
                    }
                }
            }
        }

        /*
        if(column == 0){
            return true;
        }
        else if(column != 0 && row == 0 ){ // Top Row
            if(board[row][column-1] == 1 || board[row+1][column-1] == 1 || board[row][column-2] == 1){ // Left & Diagonal Bottom Left
                return false;
            }
        }
        else if(column != 0 && row == 7){ // Bottom Row
            if(board[row][column-1] == 1 || board[row-1][column-1] == 1 || board[row][column-2] == 1){ // Left & Diagonal Upper Left
                return false;
            }
        }
        else{
            if(board[row][column-1] == 1 || board[row+1][column-1] == 1 || board[row-1][column-1] == 1){ // Left && Diagonal Bottom Left & Diagonal Upper Left
                return false;
            }

        }
        */
        /*
        if(column == 0 && row == 0){ // Upper Left Corner
            if(board[row][column+1] == 1 || board[row+1][column+1] == 1){ // Right & Diagonal Bottom Right
                return false;
            }
        }
        else if(column == 0 && row == 7){ // Bottom Left Corner
            if(board[row][column+1] == 1 || board[row-1][column+1] == 1){ // Right & Diagonal Upper Right
                return false;
            }
        }
        else if(column == 7 && row == 0){ // Upper Right Corner
            if(board[row][column-1] == 1 || board[row+1][column-1] == 1){ // Left & Diagonal Bottom Left
                return false;
            } 
        }
        else if(column == 7 && row == 7){ // Bottom Right Corner
            if(board[row][column-1] == 1 || board[row-1][column-1] == 1){
                return false;
            }
        }
        else{ // 

        }
        */

        return true;
    }

    public static void boardToString(int[][] chess){
        String chessBoard = Arrays.deepToString(chess).replace("], ", "\n").replace("[","").replace(","," ");
        chessBoard = chessBoard.substring(0, chessBoard.length() - 2);
        System.out.println(chessBoard);
    }
    

    public static void main(String[] args) {
        int[][] chess = new int[8][8];
        boardToString(chess);
        solve(chess, 0);
        System.out.println();
        boardToString(chess);
        

    }
}
