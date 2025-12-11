package StackAndQueue;

import java.util.Stack;

public class sumSubarrayMin {
    public static int sumSubarrayMins(int []arr) {
        Stack<Integer> st = new Stack<>();
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = arr.length - i;
            }
            else{
                right[i]= st.peek()-i;
            } 
            st.push(i);
        }
        st.clear();
        for(int i = 0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
               left[i] = i+1;
            }
            else{
                left[i] = i- st.peek();
            } 
            st.push(i);
        }
        long ans = 0;
        long mod = 1000000000+7;
        for(int i =0;i<arr.length;i++){
            ans=(ans+(long) arr[i]*left[i]*right[i])%mod;
        }
        return (int)(ans);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
