package pattern02_two_pointers.q01_pair_with_target_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Example 2:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;hash table;two pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Hash Table
     *
     * @param nums int[], an array of sorted numbers
     * @param target int, the target number
     * @return int[], a pair in the array whose sum is equal to the given target
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length < 2) {
            return ans;
        }
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (indexMap.containsKey(num)) {
                return new int[] {indexMap.get(num), i};
            } else {
                indexMap.put(target - num, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(Arrays.toString(solu.twoSum(new int[] {1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(solu.twoSum(new int[] {2, 5, 9, 11}, 11))); // [0, 2]
    }
}