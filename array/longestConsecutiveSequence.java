package array;

import java.util.HashSet;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestconsecutivesequence(nums));
    }

    public static int longestconsecutivesequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int ans = 1;
                int current = i;
                while (set.contains(current + 1)) {
                    ans++;
                    current = current + 1;
                }
                maxAns = Math.max(maxAns, ans);
            }
        }
        return maxAns;
    }
}
