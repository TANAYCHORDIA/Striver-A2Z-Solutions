package binarySearch;

public class max1RowWiseSorted {
    public static int rowWithMax1s(int[][] arr) {
        int maxCnt = 0;
        int ans = -1;
        for(int i=0;i<arr.length;i++){
            int cnt = lowerBound(arr[i]);
            cnt = arr[i].length-cnt;
            if(cnt>maxCnt){
                maxCnt = cnt;
                ans = i;
            }
        }
        return ans;
    }
    public static int lowerBound(int[] arr){
        int low = 0;
        int ans = arr.length;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==0)low=mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1, 1},
                       {0, 0, 1, 1},
                       {0, 0, 0, 1},
                       {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(arr));
    }
}
