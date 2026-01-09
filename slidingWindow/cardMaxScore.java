package slidingWindow;
public class cardMaxScore {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum =0;
        int rsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int ans=lsum;
        for(int i=0;i<k;i++){
            lsum-=cardPoints[k-1-i];
            rsum+=cardPoints[n-1-i];
            ans = ans>(lsum+rsum)?ans:(lsum+rsum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints,k));
    }
}
