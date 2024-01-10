public class RotateImage {
/*
*
*
*
*
* */
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
    }
    public static void rotate(int[][] matrix) {
        int[][] result= new int[matrix.length][matrix.length];
        for(int i =0;i<matrix.length;i++){
            for(int j = 0; j< matrix.length; j++) {
                result[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        for(int i =0;i<matrix.length;i++){
            for(int j = 0; j< matrix.length; j++) {
                matrix[i][j] = result[i][j];
            }
        }

    }
}
