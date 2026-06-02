package binarySearch;
public class kthMissingNumber{
    public static int findKthPositiveBrute(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)k++;
            else break;
        }
        return k;
    }
    public static int findKthPositiveOptimal(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing = arr[mid]-(mid+1);
            if(missing>=k)high=mid-1;
            else low=mid+1;
        }
        return low+k;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositiveBrute(arr,k));
        System.out.println(findKthPositiveOptimal(arr,k));
    }
}