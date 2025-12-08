package StackAndQueue;

import java.util.Stack;

public class nextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty()  && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(st.isEmpty())ans[i%n] = -1;
            else{
                ans[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int res[] = nextGreaterElements(arr);
        for(int i:res){
            System.out.print(i+" ");
        }   
    }
}
