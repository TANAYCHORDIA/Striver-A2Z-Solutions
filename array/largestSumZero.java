package array;
import java.util.*;
public class largestSumZero {
   public static void main(String args[]){
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLength(arr));
   }
   
   public static int maxLength(int arr[]) {
        int n=arr.length;
        int maxlen = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0)maxlen = Math.max(maxlen,i+1);
            if(mpp.containsKey(sum)){
                int temp = mpp.get(sum);
                maxlen = Math.max(maxlen,i-temp);
            }
            
            if(!mpp.containsKey(sum)){
                mpp.put(sum,i);
            }
        }
        return maxlen;
    }
}
