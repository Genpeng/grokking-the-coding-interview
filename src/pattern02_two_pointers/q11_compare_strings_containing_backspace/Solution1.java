package pattern02_two_pointers.q11_compare_strings_containing_backspace;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * <p>
 * Example 1:
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * <p>
 * Example 2:
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * <p>
 * Example 3:
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * <p>
 * Example 4:
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean compare(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1;
        while (i >= 0 || j >= 0) {
            i = getTrueIdx(str1, i);
            j = getTrueIdx(str2, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0) {
                // 如果能进入这个判断，肯定至少有一个大于等于 0
                return false;
            }
            if (str1.charAt(i) != str2.charAt(j)) {
                // 如果能进入这个判断，i 和 j 都大于等于 0
                return false;
            }
            --i;
            --j;
        }
        return true;
    }

    private int getTrueIdx(String s, int i) {
        int skip = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                ++skip;
                --i;
            } else if (skip > 0) {
                --skip;
                --i;
            } else {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.compare("xy#z", "xzz#") == true);
        System.out.println(solu.compare("xy#z", "xyz#") == false);
        System.out.println(solu.compare("xywrrmp", "xywrrmu#p") == true);
    }
}