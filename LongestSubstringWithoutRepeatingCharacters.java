package leetcode;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            int size = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringFromAnIndex(s.substring(i));
            if (size > longest) {
                longest = size;
            }
            if (longest >= s.length() - i) break;
        }
        System.out.println(longest);
        return longest;
    }

    public static int lengthOfLongestSubstringFromAnIndex (String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            if (!arr.contains(c)) {
                arr.add(c);
            } else {
                break;
            }
        }
        return arr.size();
    }

    public static String removeDuplicate(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            if (!arr.contains(c)) {
                arr.add(c);
            }
        }
        return arr.stream().map(e->e.toString()).collect(Collectors.joining());
    }

    public static void main (String[] args) {
        LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aaaabcd");

    }
}
