package STRINGS;

public class intToRoman {
    public static void main(String args[]){
        System.out.println(3749);
    }
    public static String convertToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i = 0;
        while(num!=0){
            if(num>=value[i]){
                num=num-value[i];
                sb.append(roman[i]);
            }
            else i++;
        }
        return sb.toString();
    }
}
