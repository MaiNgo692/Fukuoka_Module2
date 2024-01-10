public class ValidSudoku{

    public static void main(String[] args) {
        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    }
    public static boolean isValidSudoku(char[][] board) {
        boolean check ;
        check = checkRow(board);
        if(check){
            check = checkColum(board);
        }
        if(check){
            check = checkSquare(board);
        }
        return check;

    }
    public static boolean checkRow(char[][] board) {
        boolean check = true;
        for (int i = 0; i < board.length; i++) {

        }
        return check;

    }
    public static boolean checkColum(char[][] board) {
        boolean check = true;

        return check;

    }
    public static boolean checkSquare(char[][] board) {
        boolean check = true;

        return check;

    }
}
