package binarySearch;

public class search2D_2 {
    public static boolean searchMatrixBrute(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowCount = 0;
        int rowLow = 0;
        int rowHigh = n-1;
        int colLow = 0;
        int colHigh = m-1;
        int colCount = 0;
        while(rowLow<=rowHigh && colLow<=colHigh && rowCount<m && colCount<n){
            int rowMid = rowLow+(rowHigh-rowLow)/2;
            int colMid = colLow+(colHigh-colLow)/2;
            if(matrix[rowCount][rowMid]==target)return true;
            else if(matrix[rowCount][rowMid]>target){
                rowHigh = rowMid-1;
            }
            else{
                while(matrix[rowCount][rowMid]<target && rowMid<rowHigh){
                    rowMid++;
                    if(matrix[rowCount][rowMid]==target)return true;
                }
                if(matrix[rowCount][rowMid]>target)rowHigh=rowMid-1;
                else rowCount++;
            }
            if(matrix[colMid][colCount]==target)return true;
            else if(matrix[colMid][colCount]>target)colHigh = colMid-1;
            else{
                while(matrix[colMid][colCount]<target && colMid<colHigh){
                    colMid++;
                    if(matrix[colMid][colCount]==target)return true;
                }
                if(matrix[colMid][colCount]>target)colHigh=colMid-1;
                else colCount++;
            }
        }
        return false;
    }
     public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length-1;
        while(m<matrix.length && n>=0){
            if(matrix[m][n]==target)return true;
            else if(matrix[m][n]>target)n--;
            else m++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrixBrute(matrix, target));
        System.out.println(searchMatrixOptimal(matrix, target));
    }
}
