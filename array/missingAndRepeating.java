package array;

import java.util.Arrays;

public class missingAndRepeating {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2};
        System.out.println(Arrays.toString(findMissingRepeatingNumbersMaths(arr)));
    }

     public static int[] findMissingRepeatingNumbersMaths(int []arr) {
        int n = arr.length;
        long sn=(long)(n*(n+1))/2;
        long s2n = (long)(n*(n+1)*(2*n+1))/6;
        long s=0,s2=0;
        for(int i=0;i<n;i++){
            s+=(long)arr[i];
            s2 += (long)arr[i]*(long)arr[i];
        }
        long val1 = s-sn;
        long val2 = s2-s2n;
        val2 = val2/val1;
        long x =(val1+val2)/2;
        long y = x-val1;
        return new int[] {(int)x,(int)y};
    }

    public static int[] findMissingRepeatingNumbersXor(int []a) {
        int n = a.length;
        int xr = 0;
        // Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }
        //Find the bit which differentiates the 2 numbers:
        int number = (xr & ~(xr - 1));

        //divide numbers based on whether the differntiating bit is 0 or 1
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
}
