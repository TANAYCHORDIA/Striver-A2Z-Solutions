package array;

import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
       int arr[] = {2,2,2,1,1,1,1,2,2,2};
       System.out.println(majorityElementMoores(arr));
    }
    static int majorityElementMoores(int nums[]) {
        // code here
        int n=nums.length;
        int count = 0;
        int element=0;
        for(int i=0;i<n;i++){
            if(count==0){
                element = nums[i];
                count++;
            }
            else if(element==nums[i])count++;
            else count--;
        }
        //We run the below code if we are not sure if majority element exist
        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element)count1++;
        }
        if(count1>(n/2)) return element;
        return -1;
    }

    static int majorityElementHashing(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int value = mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],(value+1));
        }
        for(Integer key: mpp.keySet()){
            if(mpp.get(key)>(n/2)){
                return key;
            }
        }
        return -1;
    }
}
