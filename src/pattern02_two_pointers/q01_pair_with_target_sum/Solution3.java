package pattern02_two_pointers.q01_pair_with_target_sum;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * <p>
 * Example 2:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: array;hash table;two pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums   int[], an array of sorted numbers
     * @param target int, the target number
     * @return int[], a pair in the array whose sum is equal to the given target
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length < 2) {
            return result;
        }
        final int n = nums.length;
        int li = 0, ri = n - 1;
        while (li < ri) {
            int diff = target - nums[li] - nums[ri];
            if (diff == 0) {
                return new int[] {li, ri};
            } else if (diff < 0) {
                --ri;
            } else {
                ++li;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(Arrays.toString(solu.twoSum(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(solu.twoSum(new int[]{2, 5, 9, 11}, 11))); // [0, 2]
    }
}