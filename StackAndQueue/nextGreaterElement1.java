package StackAndQueue;
import java.util.*;
public class nextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                mpp.put(nums2[i],-1);
            }
            else{
                mpp.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        int ans[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = mpp.get(nums1[i]);
        }
        return ans;

    }
    public static void main(String[] args) {
           int[] nums1 = {4,1,2};
           int[] nums2 = {1,3,4,2};
           int[] result = nextGreaterElement(nums1, nums2);
           System.out.println(Arrays.toString(result));
    }
}
