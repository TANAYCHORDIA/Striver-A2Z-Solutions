package binarySearch;

public class floorCeil {
    public static int findFloor(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=x){
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
        int[] arr = {1,2,8,10,10,12,19};
        int x = 5;
        int floorIndex = findFloor(arr, x);
        int ceilIndex = findCeil(arr, x);
        System.out.println("Floor index: " + floorIndex);
        System.out.println("Ceil index: " + ceilIndex);
    }
}
