package array;

import java.util.*;

public class zeroOnesTwos {
  public static void main(String[] args) {
    int nums[] = { 2, 0, 2, 1, 1, 0 };
    System.out.println("Arrays before swapping:" + Arrays.toString(nums));
    sortColorsOptimal(nums);
    System.out.println("Array after swapping:" + Arrays.toString(nums));

  }

  public static void sortColorsOptimal(int[] arr) {
    int n = arr.length;
    int low = 0;
    int mid = 0;
    int high = n - 1;
    while (mid <= high) {
      if (arr[mid] == 0) {
        swap(arr, low, mid);
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        swap(arr, mid, high);
        high--;
      }
    }
    return;
  }

  static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void sortColors(int[] nums) {
    HashMap<Integer, Integer> mpp = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int value = 0;
      if (mpp.containsKey(nums[i])) {
        value = mpp.get(nums[i]);
      }
      mpp.put(nums[i], value + 1);
    }
    int j = 0;
    if (mpp.containsKey(0)) {
      for (int i = 0; i < mpp.get(0); i++) {
        nums[j] = 0;
        j++;
      }
    }

    if (mpp.containsKey(1)) {
      for (int i = 0; i < mpp.get(1); i++) {
        nums[j] = 1;
        j++;
      }
    }
    if (mpp.containsKey(2)) {
      for (int i = 0; i < mpp.get(2); i++) {
        nums[j] = 2;
        j++;
      }
    }
  }
}
