package StackAndQueue;

import java.util.*;

class slidingWindowMaximum{
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.getFirst()<=i-k)q.removeFirst();
            while(!q.isEmpty() && nums[q.getLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(i>=k-1)ans[i-k+1] = nums[q.getFirst()];
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans[] = maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));
    }
}