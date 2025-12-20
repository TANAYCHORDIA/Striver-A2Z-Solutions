package StackAndQueue;

import java.util.Stack;

public class largestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            if(st.isEmpty())pse[i]=i+1;
            else pse[i] = i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i= n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i])st.pop();
            if(st.isEmpty())nse[i] = n-i;
            else nse[i] = st.peek() - i;
            st.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int ar = heights[i] * (pse[i] + nse[i] - 1) ;
            if(max<ar)max =ar;
        }
        return max;
    }
    public int largestRectangleAreaOptimised(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max1 = 0;
        int n = heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int j = st.pop();
                int pse = st.isEmpty()?-1:st.peek();
                int area = heights[j]*(i-pse-1);
                max1 = (max1>area)?max1:area;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int i = st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            int area = heights[i]*(n-pse-1);
            max1 = (max1>area)?max1:area;
        }
        return max1;
    }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
