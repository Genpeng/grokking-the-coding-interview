package pattern01_sliding_window.q06_longest_substring_with_same_letters_after_replacement;

import java.util.HashMap;
import java.util.Map;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with
 * any letter, find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Example 2:
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 *
 * Example 3:
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int longestSubstringWithSameLetters(String s, int k) {
        final int L = s.length();
        if (L <= 1) {
            return L;
        }
        int maxLen = 0, maxRepeatTimes = 0;
        char c;
        Map<Character, Integer> freqMap = new HashMap<>(L);
        for (int li = 0, ri = 0; ri < L; ++ri) {
            c = s.charAt(ri);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxRepeatTimes = Math.max(maxRepeatTimes, freqMap.get(c));
            if (ri - li + 1 - maxRepeatTimes > k) {
                c = s.charAt(li);
                freqMap.put(c, freqMap.get(c) - 1);
                ++li;
            }
            maxLen = Math.max(maxLen, ri - li + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.longestSubstringWithSameLetters("aabccbb", 2) == 5);
        System.out.println(solu.longestSubstringWithSameLetters("abbcb", 1) == 4);
        System.out.println(solu.longestSubstringWithSameLetters("abccde", 1) == 3);
    }
}