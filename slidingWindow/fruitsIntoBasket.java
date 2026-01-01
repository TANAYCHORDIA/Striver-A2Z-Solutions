package slidingWindow;

import java.util.HashMap;

public class fruitsIntoBasket {
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int l = 0;
        int maxCount = 0;
        int n = fruits.length;
        for(int i=0;i<n;i++){
            mpp.put(fruits[i],mpp.getOrDefault(fruits[i],0)+1);
            while(mpp.size()>2){
                int f = fruits[l];
                mpp.put(f,mpp.getOrDefault(f,1)-1);
                if(mpp.get(f)==0)mpp.remove(f);
                l++;
            }
            maxCount = (i-l+1)>maxCount?(i-l+1):maxCount;
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        System.out.println(totalFruit(fruits));
    }
}
