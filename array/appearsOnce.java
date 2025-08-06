package array;

import java.util.HashMap;

public class appearsOnce {
    public static void main(String[] args) {
        int nums[]={1,2,2,3,3};
        System.out.println("Using HashMap: " + getSinglehash(nums));
        System.out.println("Using XOR: " + getSinglexor(nums));
    }
    public static int getSinglexor(int nums[]){
        int n = nums.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=nums[i];
        }
        return xor;
    }
    public static int getSinglehash(int nums[]) {
        // code here
        int n = nums.length;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++){
            int value=1;
            if(hash.containsKey(nums[i])){
                value = (hash.get(nums[i]));
                value++;
            }
            hash.put(nums[i],value);
        }
        for(int i=0;i<n;i++){
            if(hash.get(nums[i])==1){
                return nums[i];
            }
        }
        System.out.println(hash);
        return -1;
    }
}
