package STRINGS;

public class homogenousSubstring {
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
    }
    public static int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        long total = 0;
        char prev = s.charAt(0);   
        int count = 0; 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==prev && i!=0){
                count++;
            }
            else{
                total+=(((long)count*(count+1))/2)%MOD;
                prev = s.charAt(i);
                count =1;
            }
        }
        total+=(((long)count*(count+1))/2)%MOD;
        return (int)total;
    }
}
