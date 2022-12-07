package pattern05_cyclic_sort.q04_find_duplicate_number;

import utils.ArrayUtil;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only
 * one duplicate, but it can be repeated multiple times. Find that duplicate number without using any extra space.
 * You are, however, allowed to modify the input array.
 *
 * Example 1:
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 *
 * Example 2:
 * Input: [2, 1, 3, 3, 5, 4]
 * Output: 3
 *
 * Example 3:
 * Input: [2, 4, 1, 4, 4]
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
     * @param nums int[], an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’
     * @return int, the duplicate number
     */
    public int findDuplicateNumber(int[] nums) {
        // 输入 n+1 大小的数组，找出其中有且仅有一个重复的数字
        // 注意：该数字可以重复多次，即 [1, n] 范围可能缺失多个数字
        final int N = nums.length;
        int i = 0;
        while (i < N) {
            int j = nums[i] - 1; // 位置 i 上对象的正确位置
            if (i != j) { // 如果位置不正确
                if (nums[i] != nums[j]) { // 正确位置上不重复
                    ArrayUtil.swap(nums, i, j);
                } else { // 正确位置上重复，则该值就是唯一重复的数字
                    return nums[i];
                }
            } else { // 如果位置正确
                ++i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.findDuplicateNumber(new int[] {1, 4, 4, 3, 2})); // 4
        System.out.println(solu.findDuplicateNumber(new int[] {2, 1, 3, 3, 5, 4})); // 3
        System.out.println(solu.findDuplicateNumber(new int[] {2, 4, 1, 4, 4})); // 4
    }
}