package pattern01_sliding_window.q08_permutation_in_a_string;

import java.util.HashMap;
import java.util.Map;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 * - abc
 * - acb
 * - bac
 * - bca
 * - cab
 * - cba
 * <p>
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 * <p>
 * Example 1:
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * <p>
 * Example 2:
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * <p>
 * Example 3:
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * <p>
 * Example 4:
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 * ==========================================================================================================
 * <p>
 * Difficulty: Hard
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean containPatternPermutation(String s, String pattern) {
        // 步骤1：统计出 pattern 所有字符的出现次数
        Map<Character, Integer> freqMap = new HashMap<>(pattern.length());
        for (char c : pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // 步骤2：维护一个大小为 pattern.length() 的窗口向右移动，每次移动一个字符，
        // 如果当前的字符在 freqMap 中，freqMap 相应字符出现次数减 1，当该字符频率为 0 时，
        // 匹配的字符数加 1。
        // 如果在某个字符，匹配的字符数等于 freqMap 中字符的数目，说明该窗口包含 pattern
        // 里面的所有字符，返回 true；如果遍历完字符串，并没有出现，则返回 false。
        int matched = 0;
        char c;
        for (int li = 0, ri = 0; ri < s.length(); ++ri) {
            c = s.charAt(ri);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    ++matched;
                }
            }
            if (matched == freqMap.size()) {
                return true;
            }
            if (ri >= pattern.length() - 1) {
                c = s.charAt(li++);
                if (freqMap.containsKey(c)) {
                    if (freqMap.get(c) == 0) {
                        ++matched;
                    }
                    freqMap.put(c, freqMap.get(c) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.containPatternPermutation("oidbcaf", "abc") == true);
        System.out.println(solu.containPatternPermutation("odicf", "dc") == false);
        System.out.println(solu.containPatternPermutation("bcdxabcdy", "bcdyabcdx") == true);
        System.out.println(solu.containPatternPermutation("aaacb", "abc") == true);
    }
}