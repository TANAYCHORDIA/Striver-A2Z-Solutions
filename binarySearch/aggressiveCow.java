package binarySearch;

import java.util.Arrays;

public class aggressiveCow {
    public static int aggressiveCows(int[] stalls, int k){
        Arrays.sort(stalls);
        int n =stalls.length;
        int Min = 1;
        int Max = stalls[n-1]-stalls[0];
        while(Min<=Max){
            int mid = (Max+Min)/2;
            if(canPlace(stalls,k,mid)==true){
                Min = mid+1;
            }
            else Max = mid-1;
        }
        return  Max;
    }
    public static boolean canPlace(int [] stalls,int k,int dist){
        int lastPos = stalls[0];
        int cnt=1;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPos>=dist){
                lastPos=stalls[i];
                cnt++;
            }
            if(cnt>=k)return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] stalls = {1,2,4,8,9};
        int k = 3;
        System.out.println(aggressiveCows(stalls,k));
    }
}
