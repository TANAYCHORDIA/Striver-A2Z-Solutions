package binarySearch;

public class kthEleOf2Array {
    public static int kthElement(int a[], int b[], int k) {
        int cnt = 0;
        int n = a.length;
        int m = b.length;
        int l = 0;
        int r = 0;
        while(l<n && r<m){
            if(a[l]<=b[r]){
                l++;
                cnt++;
                if(cnt==k)return a[l-1];
            }
            else{
                r++;
                cnt++;
                if(cnt==k)return b[r-1];
            } 
            
        }
        while(l<n){
            l++;
            cnt++;
             if(cnt==k)return a[l-1];
        }
        while(r<m){
            r++;
            cnt++;
            if(cnt==k)return b[r-1];
        }
        return -1;
    }
    public static int kthElementOptimal(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;
        if(n>m)return kthElementOptimal(b,a,k);
        int low = Math.max(0,k-m);
        int high = Math.min(n,k);
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = k-mid1;
            int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;
            if(mid1!=0)l1 = a[mid1-1];
            if(mid2!=0)l2 = b[mid2-1];
            if(mid1<n)r1 = a[mid1];
            if(mid2<m)r2 = b[mid2];
            if(l1<=r2 && l2<=r1)return Math.max(l1,l2);
            else if(l1>r2)high = mid1-1;
            else{
                low = mid1+1;
            }
            
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[] = {2,3,6,7,9};
        int b[] = {1,4,8,10};
        int k = 5;
        System.out.println(kthElement(a,b,k));
        System.out.println(kthElementOptimal(a,b,k));
    }
}
