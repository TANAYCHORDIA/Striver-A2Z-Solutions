package binarySearch;

public class shipPackages {
   public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int high = SUM(weights,n);
        int low = MAX(weights,n);
        int ans = -1;
        while(high>=low){
            int mid = low+(high-low)/2;
            boolean check = valid(weights,days,mid,n);
            if(check){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static boolean valid(int[] weights,int days,int mid,int n){
        int noOfDays = 1;
        int Sum = 0;
        for(int i=0;i<n;i++){
            if((Sum+weights[i])>mid){
                noOfDays++;
                Sum =weights[i];
            }
            else{
                Sum+=weights[i];
            }
            if(noOfDays>days)return false;
        }
        return true;
    }
    public static int MAX(int[] weights,int n){
        int ans = -1;
        for(int i=0;i<n;i++){
            if(weights[i]>ans)ans=weights[i];
        }
        return ans;
    }

    public static int SUM(int [] weights,int n){
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=weights[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights,days));
    }
}
