package binarySearch;

public class peak {
    public static int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(mid+1<arr.length && arr[mid]<arr[mid+1])start=mid+1;
            else{
                end=mid;
                
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
}
