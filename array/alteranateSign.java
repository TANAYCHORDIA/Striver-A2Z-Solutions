package array;

import java.util.ArrayList;
import java.util.Arrays;

public class alteranateSign {
    public static void main(String[] args) {
        int arr[] = { 3, 1, -2, -5, 2, -4 };
        int nums[]={1,2,-4,-5,3,4};
        System.out.println(Arrays.toString(rearrangeArraybrute(arr)));
        System.out.println(Arrays.toString(rearrangeArrayNotequal(nums)));
    }

    public static int[] rearrangeArraybrute(int[] nums) {
        int i = 0;
        int n = nums.length;
        int arr[] = new int[n];
        for (int j = 0; j < n; j++) {
            if (nums[j] > 0) {
                arr[i] = nums[j];
                i += 2;
            }
        }
        i = 1;
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) {
                arr[i] = nums[j];
                i += 2;
            }
        }
        return arr;
    }

    public static int[] rearrangeArrayOptimal(int[] nums) {
        int posIndex = 0, negIndex = 1;
        int n = nums.length;
        int arr[] = new int[n];
        for (int j = 0; j < n; j++) {
            if (nums[j] > 0) {
                arr[posIndex] = nums[j];
                posIndex += 2;
            } else {
                arr[negIndex] = nums[j];
                negIndex += 2;
            }
        }
        return arr;
    }

    public static int[] rearrangeArrayNotequal(int nums[]) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                neg.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[(2 * i) + 1] = neg.get(i);
            }
            for (int i = neg.size() ; i < pos.size(); i++) {
                ans[neg.size() + i] = pos.get(i);
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[(2 * i) + 1] = neg.get(i);
            }
            for (int i = pos.size(); i < neg.size(); i++) {
                ans[pos.size() + i] = neg.get(i);
            }
        }

        return ans;
    }
}
