package array;

import java.util.ArrayList;

public class unionOptimal {
    public static void main(String[] args){
        int a[] = {1,3,3,5,7,7};
        int b[] = {1,2,2,5,8,8};
        System.out.println(findUnion(a, b));
    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans  = new ArrayList<>();
        int n=a.length;
        int m=b.length;
        int i=0;
        int j=0;
        while(i<n & j<m){
            if(a[i]<b[j]){
                if(ans.isEmpty() ||ans.get(ans.size()-1)!=a[i]){
                    ans.add(a[i]);
                }
                i++;
            }
            else if(a[i]>b[j]){
                if(ans.isEmpty() ||ans.get(ans.size()-1)!=b[j]){
                    ans.add(b[j]);
                }
                j++;
            }
            else if(a[i]==b[j]){
                if(ans.isEmpty() ||ans.get(ans.size()-1)!=b[j]){
                    ans.add(b[j]);
                }
                j++;
                i++;
            }
        }
        while(i<n){
                if(ans.isEmpty() ||ans.get(ans.size()-1)!=a[i]){
                    ans.add(a[i]);
                }
                i++;
        }
        while(j<m){
            if(ans.isEmpty() ||ans.get(ans.size()-1)!=b[j]){
                    ans.add(b[j]);
                }
                j++;
        }
        return ans;
    }
}
