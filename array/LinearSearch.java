package array;

public class LinearSearch {
    public static void main(String args[]){
        int nums[]={3,22,1,89,-22,14,222,321};
        int target=14;
        System.out.println("The index of target is:"+linearSearch(nums,target));
    }
    public static int linearSearch(int nums[], int target) {
    for(int i=0;i<nums.length;i++){
      if(nums[i]==target)return i;
    }
    return -1;
    }
    
}

