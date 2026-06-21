package binarySearch;
import java.util.Arrays;
public class median2DArray {
    public static int findMedianBrute(int mat[][], int n, int m) {
        int arr[] = new int[n*m];
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[cnt]=mat[i][j];
                cnt++;
            }
        }
        Arrays.sort(arr);
        return arr[(n*m)/2];
    }
    public static int findMedianOptimal(int mat[][], int n, int m) {
        int low = Min(mat,n,m);
        int high = Max(mat,n,m);
        int tar = (n*m)/2;
        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = Count(mat,n,m,mid);
            if(cnt<=tar)low=mid+1;
            else high = mid-1;
        }
        return low;
    }
    public static int Min(int mat[][],int n,int m){
        int low = mat[0][0];
        for(int i=1;i<n;i++){
            if(mat[i][0]<low)low = mat[i][0];
        }
        return low;
    }
    public static int Max(int mat[][],int n,int m){
        int high = mat[0][m-1];
        for(int i=1;i<n;i++){
            if(mat[i][m-1]>high)high = mat[i][m-1];
        }
        return high;
    }
    public static int Count(int mat[][],int n,int m,int mid){
        int cnt = 0;
        for(int i=0;i<n;i++){
            cnt+=UpperBound(mat[i],mid,m);
        }
        return cnt;
    }
    public static int UpperBound(int []arr, int x, int n){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int n = mat.length;
        int m = mat[0].length;
        int median = findMedianBrute(mat, n, m);
        System.out.println("Median of the matrix is: " + median);
        int medianOptimal = findMedianOptimal(mat, n, m);
        System.out.println("Median of the matrix (Optimal) is: " + medianOptimal);
    }
}
