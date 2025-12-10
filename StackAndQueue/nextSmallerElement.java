package StackAndQueue;
import java.util.*;
public class nextSmallerElement {
    static ArrayList<Integer> nextsmallerelement(ArrayList<Integer> arr, int n){
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr.get(i))st.pop();
            if(st.isEmpty())nse[i] = -1;
            else nse[i] = st.peek();
            st.push(arr.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i:nse){
            ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,5,2,10,8));
        int n = arr.size();
        ArrayList<Integer> result = nextsmallerelement(arr, n);
        System.out.println(result);
    }
}
