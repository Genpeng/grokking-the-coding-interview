package pattern05_cyclic_sort.q02_find_missing_number_leetcode0268;

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
public class Solution2 {
    /**
     * 解法二：Bit Manipulation
     * 对于任意一个整数 x，都有：
     * - x xor 0 = x
     * - x xor x = 0
     * 因此，如果我们在输入数组后面追加 [0, n] 范围内的数（n+1 个），加上输入数组已有的 n 个数，
     * 总共有 2n+1 个整数，且其中有 n 个数出现 2 次，1 个数出现 1 次。由异或运算的结合律和
     * 交换律可知，这 2n+1 个数异或后的结果就是只出现 1 次的数字。
     *
     * 复杂度分析：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums int[], an integer array containing n distinct numbers in the range [0, n]
     * @return int, the missing number in the range
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= nums.length; ++i) {
            xor ^= i;
        }
        return xor;
    }
}