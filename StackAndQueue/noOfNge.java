package StackAndQueue;

public class noOfNge {
    public static int[] count_NGE(int arr[], int indices[]) {
        int ans[] = new int[indices.length];
        for(int i=0;i<indices.length;i++){
            int cnt = 0;
            for(int j=indices[i];j<arr.length;j++){
                if(arr[indices[i]]<arr[j])cnt++;
            }
            ans[i]= cnt;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,2,10,8};
        int indices[] = {0,2,1,3};
        int ans[] = count_NGE(arr,indices);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
