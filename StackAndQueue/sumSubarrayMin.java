package StackAndQueue;

import java.util.Stack;

/**
 * Problem: Sum of Subarray Minimums
 * Given an array, find the sum of minimum elements of all possible subarrays.
 * 
 * Approach: Use monotonic stack to find contribution of each element
 * - For each element, find how many subarrays it serves as the minimum
 * - Count = (elements to left where it's min) × (elements to right where it's min)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class sumSubarrayMin {
    public static int sumSubarrayMins(int []arr) {
        // Stack stores indices in increasing order of their values
        Stack<Integer> st = new Stack<>();
        
        // left[i] = number of elements to the left where arr[i] is minimum
        int left[] = new int[arr.length];
        
        // right[i] = number of elements to the right where arr[i] is minimum
        int right[] = new int[arr.length];
        
        // Step 1: Calculate right[] - Find next smaller element to the right
        // Traverse from right to left
        for(int i=arr.length-1;i>=0;i--){
            // Pop elements that are greater than current (maintain increasing stack)
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            
            // If stack is empty, no smaller element on right
            // Current element is minimum for all elements till the end
            if(st.isEmpty()){
                right[i] = arr.length - i;
            }
            else{
                // Distance to next smaller element
                right[i]= st.peek()-i;
            } 
            
            // Push current index to stack
            st.push(i);
        }
        // Clear stack for next calculation
        st.clear();
        
        // Step 2: Calculate left[] - Find previous smaller or equal element to the left
        // Traverse from left to right
        for(int i = 0;i<arr.length;i++){
            // Pop elements that are greater than or equal to current
            // Note: >= is used here to handle duplicates (avoid double counting)
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            
            // If stack is empty, no smaller element on left
            // Current element is minimum for all elements from start
            if(st.isEmpty()){
               left[i] = i+1;
            }
            else{
                // Distance to previous smaller element
                left[i] = i- st.peek();
            } 
            
            // Push current index to stack
            st.push(i);
        }
        // Step 3: Calculate the final answer
        long ans = 0;
        long mod = 1000000000+7; // Modulo for large numbers
        
        // For each element, calculate its contribution:
        // arr[i] × left[i] × right[i]
        // This represents: value × (number of subarrays where it's minimum)
        for(int i =0;i<arr.length;i++){
            // Multiply: element value × left count × right count
            // This gives total contribution of arr[i] as minimum in all its subarrays
            ans=(ans+(long) arr[i]*left[i]*right[i])%mod;
        }
        
        return (int)(ans);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
