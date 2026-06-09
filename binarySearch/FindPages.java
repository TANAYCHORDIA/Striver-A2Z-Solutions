package binarySearch;
public class FindPages {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if(n<k)return -1;
        int sum = arr[0];//upper limit = sum
        int high = arr[0];//lower limit = high
        for(int i=1;i<n;i++){
            sum+=arr[i];
            if(high<arr[i])high = arr[i];
        }
        while(high<=sum){
            int mid = high + (sum-high)/2;
            int ans = cntStu(arr,mid);
            if(ans>k)high=mid+1;
            else sum = mid-1;
        }
        return high;
    }
    public static int cntStu(int arr[],int pages){
        int cnt = 1;
        int hold = 0;
        for(int i=0;i<arr.length;i++){
            if(hold+arr[i]<=pages)hold+=arr[i];
            else{
                cnt++;
                hold=arr[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int k = 2;
        System.out.println(findPages(arr,k));
    }
}