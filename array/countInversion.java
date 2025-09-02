package array;

import java.util.ArrayList;

public class countInversion {
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }
    public static int merge(int arr[],int low,int mid,int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int cnt = 0;
        while(left<=mid && right<=high){
            if(arr[left]>arr[right]){
                cnt+=(mid-left+1);
                temp.add(arr[right]);
                right++;
            }
            else{
                temp.add(arr[left]);
                left++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
        return cnt;
    }
    public static int ms(int arr[],int low,int high){
        int cnt=0;
        if(low>=high)return cnt;
        int mid = (low+high)/2;
        cnt+=ms(arr,low,mid);
        cnt+=ms(arr,mid+1,high);
        cnt+=merge(arr,low,mid,high);
        return cnt;
    }
    public static int inversionCount(int arr[]) {
        int n = arr.length;
        return ms(arr,0,n-1);
    }
}

