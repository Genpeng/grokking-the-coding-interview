package pattern05_cyclic_sort.q02_find_missing_number_leetcode0268;

import java.util.HashSet;
import java.util.Set;

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
public class Solution1 {
    /**
     * 解法一：Hash Table
     * 用一个数组标记输入数组（大小为 n）中各个数字是否出现，如果出现，标记为 1；否则为 0。
     * 之后，遍历一次标记数组，返回值为 0 的索引，即为未出现的数字。
     *
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums int[], an integer array containing n distinct numbers in the range [0, n]
     * @return int, the missing number in the range
     */
    public int missingNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        final int N = nums.length;
        for (int i = 0; i <= N; ++i) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法一：Hash Table
     * 用一个数组标记输入数组（大小为 n）中各个数字是否出现，如果出现，标记为 1；否则为 0。
     * 之后，遍历一次标记数组，返回值为 0 的索引，即为未出现的数字。
     *
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums int[], an integer array containing n distinct numbers in the range [0, n]
     * @return int, the missing number in the range
     */
    public int missingNumberV2(int[] nums) {
        final int N = nums.length;
        int[] flags = new int[N + 1];
        for (int num : nums) {
            flags[num] = 1;
        }
        for (int i = 0; i < flags.length; ++i) {
            if (flags[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}