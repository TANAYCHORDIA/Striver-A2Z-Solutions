package array;


class SecondLargest {
    public static void main(String[] args) {
        int arr[]={22,11,2,3,553,12,778,12}; 
        int n=arr.length;
        int max=arr[0];
        int smax= Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                smax=max;
                max=arr[i];
            }
            else if(smax<arr[i] & max>arr[i]) smax=arr[i];
        }
        System.out.println("Second largest number is:"+smax);
    }
}