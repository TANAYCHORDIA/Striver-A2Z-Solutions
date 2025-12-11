package StackAndQueue;

class trapRainWater{
    public static int min(int a,int b){
        return a<b?a:b;
    }
    public static  int trapBrute(int[] height) {
        int n = height.length;
        int arrSuffix[] = new int[n];
        int arrPrefix[] = new int[n];
        int maxL = height[0];
        int maxR = height[n-1];
        int j = n-1;
        int water = 0;
        for(int i=0;i<n;i++){
            if(height[i]>maxL)maxL=height[i];
            arrPrefix[i] = maxL;
            if(height[j]>maxR)maxR = height[j];
            arrSuffix[j] = maxR;
            j--;
        }
        for(int i=0;i<n;i++){
            water+= min(arrPrefix[i],arrSuffix[i]) - height[i];
        }
        return water;
    }
    public static int trapOptimal(int height[]){
        int left = 0;
        int right = height.length-1;
        int maxL = 0;
        int maxR = 0;
        int water = 0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=maxL){
                    maxL = height[left];
                }else{
                    water+= maxL - height[left];
                }
                left++;
            }else{
                if(height[right]>=maxR){
                    maxR = height[right];
                }else{
                    water+= maxR - height [right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String args[]){
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapBrute(height));
        System.out.println(trapOptimal(height));
    }
}