package array;
import java.util.*;
public class xorK {
    public static void main(String args[]){
        int arr[] ={1, 2, 3, 2};
        int k= 2;
        System.out.println(subarraysWithSumK(arr, k));
    }
    public static int subarraysWithSumK(int []arr, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int prefixXor=0;
        int n = arr.length;
        int count=0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            prefixXor ^= arr[i];
            int complement = k^prefixXor;
            if(mpp.containsKey(complement)){
                count+=mpp.get(complement);  
            }
                int temp = mpp.getOrDefault(prefixXor,0);
                mpp.put(prefixXor,temp+1);
        }
        return count;
    }
}
