package binarySearch;

public class firstLast {
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        int first=indexfind(nums,target,true);
        int last=indexfind(nums,target,false);
        arr[0]=first;
        arr[1]=last;
        return arr;
    }
    public static int indexfind(int[] nums,int target,boolean firstcheck){
        int start=0;
        int last=nums.length-1;
        int ans=-1;
        while(start<=last){
            int mid = start+(last-start)/2;
            if(target>nums[mid])start=mid+1;
            else if(target<nums[mid])last=mid-1;
            else{
                ans = mid;
                if(firstcheck){
                    last=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(arr, target);
        System.out.println("First and Last Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
