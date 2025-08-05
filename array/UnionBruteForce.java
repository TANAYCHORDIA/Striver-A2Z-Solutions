package array;

import java.util.*;

public class UnionBruteForce {
    public static void main(String[] args){
        int arr1[]={1,2,3,4,4,4,8,9};
        int arr2[]={2,2,2,5,6,7,7,10};
        ArrayList<Integer> ans= bruteUnion(arr1, arr2);
        System.out.println(ans);
    }
    public static ArrayList<Integer> bruteUnion(int arr1[],int arr2[]){
        Set<Integer> unionset = new HashSet<>();
        for(int i:arr1){
            unionset.add(i);
        }
        for(int i:arr2){
            unionset.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer i:unionset){
            ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}
