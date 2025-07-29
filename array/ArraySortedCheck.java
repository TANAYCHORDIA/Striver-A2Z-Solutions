package array;

public class ArraySortedCheck {
    public static void main(String[] args){
        int a[]={1,2,3,4,4,4,5};
        int ans=1;
        for(int i=0;i<a.length-1;i++){
            if(!(a[i]<=a[i+1])){
                ans=0;
                break;
            } 
        }
        if(ans==1) System.out.println("Array is sorted");
        else System.out.println("Array is not sorted");
    }
    
}
