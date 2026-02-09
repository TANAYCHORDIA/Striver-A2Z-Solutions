package binarySearch;
public class kokoBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        while(low<=high){
            int mid = low+(high-low)/2;
            long hrs = hours(piles,mid);
            if(hrs>h)low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    public static int max(int[] piles){
        int maxNo = piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>maxNo)maxNo = piles[i];
        }
        return maxNo;
    }
    public static long hours(int piles[],int mid){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/(double)mid);
        }
        return total;
    }
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles,h));
    }
}
