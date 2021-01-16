package pattern01_sliding_window.q10_minimum_window_containing_substring;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters
 * of the given pattern.
 *
 * Example 1:
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 *
 * Example 2:
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 *
 * Example 3:
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public String minimumWindowContainsPattern(String s, String pattern) {
        int m = s.length(), n = pattern.length();
        if (m < n) {
            return "";
        }
        // 步骤1：统计 pattern 中所有字符的出现次数
        int[] freqMap = new int[128];
        for (char c : pattern.toCharArray()) {
            ++freqMap[c];
        }
        // 步骤2：用一个可变的窗口向右滑动，一开始右边界尽可能向右滑动，滑动到包含所有字符，
        // 之后再搜索左边界找出最短的子串
        int count = n;
        int minLen = Integer.MAX_VALUE, startIndex = -1;
        char c;
        for (int li = 0, ri = 0; ri < m; ++ri) {
            c = s.charAt(ri);
            if (freqMap[c]-- > 0) {
                --count;
            }
            while (count == 0) {
                if (ri - li + 1 < minLen) {
                    startIndex = li;
                    minLen = Math.min(minLen, ri - li + 1);
                }
                c = s.charAt(li++);
                if (++freqMap[c] > 0) {
                    ++count;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.minimumWindowContainsPattern("aabdec", "abc").equals("abdec"));
        System.out.println(solu.minimumWindowContainsPattern("abdbca", "abc").equals("bca"));
        System.out.println(solu.minimumWindowContainsPattern("adcad", "abc").equals(""));
    }
}