class LargestElement{
    public static void main(String[] args){
        int arr[]={22,11,2,3,553,12,778,12};
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i])max=arr[i];
        }
        System.out.println("the largest element is:"+max);
    }
}