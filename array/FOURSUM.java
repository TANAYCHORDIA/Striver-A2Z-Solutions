package array;
import java.util.*;
public class FOURSUM {
    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && nums[j]==nums[j-1])continue;
                int k = j+1;
                int x = n-1;
                while(x>k){
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[x];
                    if(sum>target){
                        x--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[x]));
                        x--;
                        k++;
                        while(x>k && nums[k]==nums[k-1])k++;
                        while(x>k && nums[x]==nums[x+1])x--;
                    }
                }
            }
        }
        return ans;
    }
}

