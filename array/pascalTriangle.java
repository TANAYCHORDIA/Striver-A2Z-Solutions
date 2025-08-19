package array;

import java.util.ArrayList;

public class pascalTriangle {
    public static void main(String[] args){
        System.out.println(generateRow(4));
    }

    static long ncr(int r,int c){//use 0 indexing for ncr
        long ans = 1;
        for(int i=0;i<c;i++){
            ans = ans*(r-i);
            ans = ans/(i+1);
        }
        return ans;
    }

    static ArrayList<Integer> generateRow(int n){
        long mul =1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int)mul);
        for(int i=1;i<n;i++){
            mul = mul*(n-i);
            mul = mul/i;
            ans.add((int)mul);
        }
        return ans;
    }

    static ArrayList<ArrayList<Integer>> genratePascal(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
}
