package pattern01_sliding_window.q07_longest_subarray_with_ones_after_replacement;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * <p>
 * Example 2:
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 * ==========================================================================================================
 * <p>
 * Difficulty: Hard
 * Tags: array;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int longestSubarrayWithOnes(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int maxLen = 0, oneFreq = 0;
        for (int li = 0, ri = 0; ri < n; ++ri) {
            if (nums[ri] == 1) {
                ++oneFreq;
            }
            if (ri - li + 1 - oneFreq > k) {
                if (nums[li++] == 1) {
                    --oneFreq;
                }
            }
            maxLen = Math.max(maxLen, ri - li + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.longestSubarrayWithOnes(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2) == 6);
        System.out.println(solu.longestSubarrayWithOnes(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3) == 9);
    }
}