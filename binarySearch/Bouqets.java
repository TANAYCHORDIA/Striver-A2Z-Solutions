package binarySearch;
public class Bouqets {
    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k)return -1;
        int low = min(bloomDay);
        int high = max(bloomDay);
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            int b = noOfBouqets(bloomDay,k,mid);
            if(b<m)low = mid+1;
            else if(b>=m){
                if(mid<ans)ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static int max(int[] bloomDay){
        int maxNo = bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            if(bloomDay[i]>maxNo)maxNo = bloomDay[i];
        }
        return maxNo;
    }
    public static int min(int[] bloomDay){
        int minNo = bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            if(bloomDay[i]<minNo)minNo = bloomDay[i];
        }
        return minNo;
    }
    public static int noOfBouqets(int[] bloomDay,int k,int mid){
        int cnt=0;
        int n = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid)cnt++;
            else{
                n +=(cnt/k);
                cnt=0;
            }
        }
        n +=(cnt/k);
        return n;
    }
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay,m,k));
    }
}
