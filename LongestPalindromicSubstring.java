package leetcode;

public class LongestPalindromicSubstring {
    public static int longest = 0;
    public static void main (String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        if (s.equals("")) return "";
        if (s.length() == 1) return  s;
        int len = s.length();
        int firstInd = 0;
        int lastInd = 0;
        for (int i = 0; i < len; i++) {
            int temp = longestPalindrome(i, s);
            if (temp != -1) {
                firstInd = i;
                lastInd = temp;
            }
        }
        return s.substring(firstInd, lastInd + 1);
    }

    public static int longestPalindrome(int startIndex, String s) {
        int lastIndex = 0;
        int currentLongest = longest;
        for (int i = startIndex + 1; i < s.length(); i++) {
            if (s.charAt(startIndex) == s.charAt(i)) {
                if (i - startIndex > longest) {
                    if (checkPalindrome(s.substring(startIndex, i + 1))) {
                        longest = i - startIndex;
                        lastIndex = i;
                    }
                }
            }
        }

        return longest > currentLongest? lastIndex : -1;
    }

    public static boolean checkPalindrome(String s) {
        int len = s.length();
        if (len%2 == 0) {
            String s1 = s.substring(0, (len - 1)/2 + 1);
            String s2 = s.substring((len - 1)/2 +1, len);
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        } else {
            String s1 = s.substring(0, (len - 1)/2);
            String s2 = s.substring((len - 1)/2 +1, len);
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
