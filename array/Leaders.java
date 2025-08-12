package array;

import java.util.ArrayList;
import java.util.Collections;

public class Leaders {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr));
    }

    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n= arr.length;
        int max = arr[n-1];
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max){//if duplicates to be allowed (arr[i]>=max)
                max=arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
