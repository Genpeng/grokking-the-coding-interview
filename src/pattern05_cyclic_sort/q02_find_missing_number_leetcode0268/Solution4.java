package pattern05_cyclic_sort.q02_find_missing_number_leetcode0268;

import utils.ArrayUtil;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
 * that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
 * in the range since it does not appear in nums.
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number
 * in the range since it does not appear in nums.
 *
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number
 * in the range since it does not appear in nums.
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 104
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array; sorting; hash table; bit manipulation; math;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * 解法四
     * 因为输入数组的范围是 [0, n]，因此，可以根据数组的值把数组放到对应的位置上（比如：0 放到 0 索引位置上），
     * 此时有两种情况：
     * 1. 缺失的数字小于 n，则数字 n 在缺失数字的索引上，比如：[4, 0, 3, 1] 缺少 2，调整位置后变为 [0, 1, 4, 3]，
     *    4 会在 2 的位置上，即第一个索引位置的值不等于索引的位置，即为缺失的数字，上例为 2
     * 2. 缺失的数字等于 n，比如：[2, 0, 3, 1]，调整位置后变为 [0, 1, 2, 3]，则缺失的数字为 n
     *
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums int[], an integer array containing n distinct numbers in the range [0, n]
     * @return int, the missing number in the range
     */
    public int missingNumber(int[] nums) {
        final int N = nums.length;
        int i = 0;
        while (i < N) {
            int j = nums[i]; // i 位置的对象实际应该放置的位置
            if (j < N && nums[i] != nums[j]) { // 📢 为什么是 nums[nums[i]] != nums[i]？
                ArrayUtil.swap(nums, i, j);
            } else {
                ++i;
            }
        }
        for (i = 0; i < N; ++i) {
            if (i != nums[i]) {
                return i;
            }
        }
        return N;
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}