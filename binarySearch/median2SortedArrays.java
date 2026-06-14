package binarySearch;

public class median2SortedArrays {
    public static double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n+m];
        int n1 = 0;
        int n2 = 0;
        while(n1<n && n2<m){
            if(nums1[n1]<=nums2[n2]){
                arr[n1+n2]=nums1[n1];
                n1++;
            }
            else {
                arr[n1+n2]=nums2[n2];
                n2++;
            }
        }
        if(n1<n){
            for(int i=n1;i<n;i++){
                arr[n2+i] = nums1[i];
            }
        }
        else{
            for(int i=n2;i<m;i++){
                arr[n1+i] = nums2[i];
            }
        }
        if((n+m)%2==0)return ((double)arr[(n+m)/2 - 1] + (double)arr[(n+m)/2]) / 2.0;
        return (double)arr[(n+m)/2];
    }
    public static double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int target = (n+m)/2;
        int even = 0;
        if((n+m)%2!=0)even = 0;
        else even=1;
        int n1=0,n2=0,i=0;
        int last = 1;
        while (n1<n && n2<m){
            if(nums1[n1]<nums2[n2]){
                n1++;
                i++;
                if(i==(target+1)){
                    if(even==0)return nums1[n1-1];
                    else {
                        if(last == 1)return ((double)(nums1[n1-2])+(double)(nums1[n1-1]))/2.0;
                        else return ((double)(nums2[n2-1])+(double)(nums1[n1-1]))/2.0;
                    }
                }
                last =1;
            }
            else{
                n2++;
                i++;
                if(i==(target+1)){
                    if(even==0)return nums2[n2-1];
                    else {
                        if(last == 1)return ((double)(nums1[n1-1])+(double)(nums2[n2-1]))/2.0;
                        else return ((double)(nums2[n2-2])+(double)(nums2[n2-1]))/2.0;
                    }
                }
                last =2;
            }

        }
        if(n1<n){
            for(int j=n1;j<n;j++){
                i++;
                if(i==(target+1)){
                    if(even==0)return nums1[j];
                    else {
                        if(last == 1)return ((double)(nums1[j-1])+(double)(nums1[j]))/2.0;
                        else return ((double)(nums2[n2-1])+(double)(nums1[j]))/2.0;
                    }
                }
                last =1;
            }
        }
        if(n2<m){
            for(int j=n2;j<m;j++){
                i++;
                if(i==(target+1)){
                    if(even==0)return nums2[j];
                    else {
                        if(last == 1)return ((double)(nums1[n1-1])+(double)(nums2[j]))/2.0;
                        else return ((double)(nums2[j-1])+(double)(nums2[j]))/2.0;
                    }
                }
                last =2;
            }
        }
        return 1;
    }
    public static double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {
    	int n = nums1.length;
        int m = nums2.length;
        int even = 0;
        if((n+m)%2==0)even=1;
        if(n>m) return BS(nums2,nums1,m,n,even);
        else return BS(nums1,nums2,n,m,even);
    }
    public static double BS(int small[],int big[],int s,int b,int even){
        int low = 0;
        int high = s;
        int sym = 0; 
        if(even==1)sym=(s+b)/2;
        else sym = (s+b+1)/2;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = sym-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1==0);
            else l1 = small[mid1-1];
            if(mid1<s)r1 = small[mid1];
            if(mid2==0);
            else l2 = big[mid2-1];
            if(mid2<b)r2 = big[mid2];
            if(l2>r1)low = mid1+1;
            else if(l1>r2)high=mid1-1;
            else{
                if(even==1){
                    return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
                }
                return Math.max(l1,l2);
            }
            
        }
        return  -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArraysBrute(nums1,nums2));
        System.out.println(findMedianSortedArraysBetter(nums1,nums2));
        System.out.println(findMedianSortedArraysOptimal(nums1,nums2));
    }
}
