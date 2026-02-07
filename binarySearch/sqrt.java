package binarySearch;
public class sqrt {
    public static int mySqrt(int x) {
        int low  = 0;
        int high = x;
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            long square = (long)mid*mid;
            if(square==x)return mid;
            else if(square>x)high = mid-1;
            else {
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }   
}
