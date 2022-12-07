package pattern05_cyclic_sort.q03_find_all_missing_number;

import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates,
 * which means some numbers will be missing. Find all those missing numbers.
 *
 * Example 1:
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 *
 * Example 2:
 * Input: [2, 4, 1, 2]
 * Output: 3
 *
 * Example 3:
 * Input: [2, 3, 2, 1]
 * Output: 4
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法一
     *
     * 复杂度分析：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     *
     * @param nums int[], an unsorted array containing numbers taken from the range 1 to n
     * @return List<Integer>, all missing numbers
     */
    public List<Integer> findAllMissingNumber(int[] nums) {
        final int N = nums.length;
        int i = 0;
        while (i < N) {
            int j = nums[i] - 1; // 位置 i 对象的正确放置位置
            // 📢 这里是 nums[nums[i]-1] != nums[i]
            // 因为数组中存在重复，比如：[2, 2, 1, 4]，索引 0 的对象为 2，跟它正确位置的对象调换后，
            // 数组还是 [2, 2, 1, 4]，无法跳到下一个位置，会陷入死循环
            // 用 nums[nums[i]-1] != nums[i] 有两种情况：
            // 1. i = nums[i]-1，即它已经在真实的位置上了，那么 nums[nums[i]-1] = nums[i]
            // 2. i 位置的值和它正确位置 nums[i]-1 的值已经相等了，不用换了
            if (nums[i] != nums[j]) {
                ArrayUtil.swap(nums, i, j);
            } else {
                ++i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < N; ++i) {
            if (i != nums[i]-1) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.findAllMissingNumber(new int[] {2, 3, 1, 8, 2, 3, 5, 1})); // 4, 6, 7
        System.out.println(solu.findAllMissingNumber(new int[] {2, 4, 1, 2})); // 3
        System.out.println(solu.findAllMissingNumber(new int[] {2, 3, 2, 1})); // 4
    }
}