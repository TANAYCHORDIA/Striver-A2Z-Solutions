package array;

public class RemoveDuplicate {
    public static void main(String args[]){
        int arr[]= {0,0,1,1,1,2,2,3,3,4};
        int n = arr.length;
        int i =0;
        for(int j=1;j<n;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println("Number of unique elements:"+(i+1));
    }
}
