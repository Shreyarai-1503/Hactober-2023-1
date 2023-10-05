public class nQueens {

    public static boolean nQueen (char board[][], int row){
        if(row == board.length){
            return true;
        }
        // column loop
        for(int col=0; col<board.length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                if(nQueen_1sol(board, row+1)){
                    return true;
                }
                board[row][col] = 'x';  //backtracking
            }
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col) {
        //vertical
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length ; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("------------chess board------------");
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 5;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 'x';
            }
        }
        
        if(nQueen(board, 0)){
            printBoard(board);
        }
        else{
            System.out.println("No Solution");
        }
    }
}
