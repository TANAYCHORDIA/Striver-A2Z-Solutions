package binarySearch;
public class nthRoot {
    public static int nthroot(int n, int m) {
        int low  = 0;
        int high = m;
        while(low<=high){
            int mid = low+(high-low)/2;
            int res = pow(mid,n,m);
            if(res==1)return mid;
            else if(res == 0)high = mid-1;
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public static int pow(int mid,int n,int m){
        long ans = 1;
        for(int i=0;i<n;i++){
            ans*=mid;
            if(ans>m)return 0;
            
        }
        if(ans==m)return 1;
        return 2;
    } 
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(nthroot(n,m));
    }
}
