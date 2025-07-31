package array;
import java.util.Arrays;
public class RotateArrayKTimes {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k=3;
        int n=arr.length;
        k=k%n;
        System.out.println("Original array:"+Arrays.toString(arr));
        OptimalRotateKleft(arr,k,n);
        System.out.println("Reversed array:"+Arrays.toString(arr));
    }
    public static void OptimalRotateKleft(int[] nums,int k,int n){
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        reverse(nums,0,n-1);

    }
    public static void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
  public static void RotateKleft(int[] nums,int k){
        int n= nums.length;
        if(n==0)return;
        
        k=k%n;
        
        if(k==0)return;
        int temp[] =  new int[k];
        for(int i=0;i<k;i++){
            temp[i]=nums[i];
       } 
       
       for(int i=0;i<n-k;i++){
           nums[i]=nums[i+k];
       }
        
       for(int i=0;i<k;i++){
            nums[n - k + i] = temp[i];
       }
}   
}
