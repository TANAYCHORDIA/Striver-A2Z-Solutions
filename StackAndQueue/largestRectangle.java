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
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
