package array;

import java.util.Arrays;

public class rotateImageorMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Before rotating:"+Arrays.deepToString(matrix));
        rotateClockwise(matrix);
        System.out.println("rotating clockwise:"+Arrays.deepToString(matrix)); 
        int matrix1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateAntiClockwise(matrix1);
        System.out.println("rotating anti clockwise:"+Arrays.deepToString(matrix1));
    }
    public static void rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void rotateAntiClockwise(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n/2;i++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }

    
}
