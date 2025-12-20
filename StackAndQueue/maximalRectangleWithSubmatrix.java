package StackAndQueue;

import java.util.Stack;

public class maximalRectangleWithSubmatrix {
    public static int largestRectangleArea(int[] heights) {
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
    public static int maximalRectangle(char[][] matrix) {
        int maxR = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int psum[][] = new int[n][m];
        for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1')sum+=1;
                else sum = 0;
                psum[i][j] = sum;
            }
        }
        for(int i=0;i<psum.length;i++){
            int res = largestRectangleArea(psum[i]);
            if(res>maxR)maxR = res;
        }
        return maxR;
    }
    public static void main(String[] args) {
        char matrix[][] = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
