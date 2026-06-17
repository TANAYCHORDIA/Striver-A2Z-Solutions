package binarySearch;

public class BS2DARRAY {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n-1;
        int cnt = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]>target)high = mid-1;
            else if(matrix[mid][m-1]<target)low=mid+1;
            else{
                int innerLow = 0;
                int innerHigh = m-1;
                while(innerLow<=innerHigh){
                    int innerMid = innerLow + (innerHigh-innerLow)/2;
                    if(matrix[mid][innerMid]>target)innerHigh = innerMid-1;
                    else if(matrix[mid][innerMid]<target)innerLow = innerMid+1;
                    else{
                        return true;
                    }
                    cnt = 1;
                }
                if(cnt==1)break;

            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 7},
                       {10, 11, 16, 20},
                       {23, 30, 34, 60}};
        System.out.println(searchMatrix(arr, 3));
    }
}
