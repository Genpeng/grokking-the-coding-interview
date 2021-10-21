package pattern01_sliding_window.q09_string_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * <p>
 * Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
 * - abc
 * - acb
 * - bac
 * - bca
 * - cab
 * - cba
 * <p>
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * <p>
 * Example 1:
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * <p>
 * Example 2:
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 * ==========================================================================================================
 * <p>
 * Difficulty: Hard
 * Tags: string;sliding window
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public List<Integer> findStringAnagrams(String s, String pattern) {
        List<Integer> result = new ArrayList<Integer>();
        // 步骤1：统计 pattern 中所有字符的出现次数
        Map<Character, Integer> freqMap = new HashMap<>(pattern.length());
        for (char c : pattern.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // 步骤2：采用一个跟 pattern 一样大小的窗口向右滑动，找出所有满足的 anagrams
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
                result.add(li);
            }
            if (ri >= pattern.length() - 1) {
                c = s.charAt(li++);
                if (freqMap.containsKey(c)) {
                    if (freqMap.get(c) == 0) {
                        --matched;
                    }
                    freqMap.put(c, freqMap.get(c) + 1);
                }
            }
        }
        return result;
    }
}