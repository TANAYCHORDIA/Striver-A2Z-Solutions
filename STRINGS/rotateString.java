package STRINGS;
public class rotateString {
    public static void main(String[] args) {
        String s="abcde";
        String goal ="cdeab" ;
        System.out.println(rotateStrings(s, goal));
    }
    public static boolean rotateStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);

    }
}
