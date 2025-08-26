package array;

import java.util.Arrays;

public class mergeArrayInPlace {
    public static void main(String args[]){
        int a[] = {2, 4, 7, 10};
        int b[] = {2, 3};
        gap(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    public static void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int i =n-1;
        int j = 0;
        while(i>=0 && j<m){
            if(a[i]>b[j]){
                int temp = a[i];
                a[i] =b[j];
                b[j]=temp;
                i--;
                j++;
            }
            else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    static void swapIfGreater(int arr1[],int arr2[],int index1,int index2){
        if(arr1[index1]>arr2[index2]){
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
        return;
    }
    public static void gap(int a[],int b[]){
        int n = a.length;
        int m =b.length;
        int len = m+n;

        int gap = (len/2)+(len%2);

        while(gap>0){
            int left =0;
            int right = left+gap;
            while(right<len){
                if(left<n && right>=n){
                    swapIfGreater(a, b, left, right-n);
                }
                else if(left>=n){
                    swapIfGreater(b, b, left-n, right-n);
                }
                else{
                    swapIfGreater(a, a, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1)break;
            gap = (gap/2)+(gap%2);
        }
        return;
    }
}
