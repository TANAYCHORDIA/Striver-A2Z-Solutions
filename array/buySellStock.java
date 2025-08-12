package array;

public class buySellStock {
    public static void main(String[] args) {
        int prices[] = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int buy=0;
        int maxprofit=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            if(prices[buy]>prices[i]){
                buy=i;
            }
            if(i>buy && prices[i]-prices[buy]>maxprofit){
                maxprofit=prices[i]-prices[buy];
            }
        }
        return maxprofit;
    }
}
