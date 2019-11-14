package leetcode;

public class LongestPalindromicSubstring2 {
    public static void main (String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        if (s.equals("")) return "";
        if (s.length() == 1) return  s;
        int len = s.length();


    }
}
