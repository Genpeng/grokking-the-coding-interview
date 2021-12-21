package pattern02_two_pointers.q02_remove_duplicates;

import utils.ArrayUtil;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
 * after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 * <p>
 * Example 1:
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * <p>
 * Example 2:
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: array;fast & slow pointers;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        final int L = nums.length;
        if (L < 2) {
            return L;
        }
        int i = 0; // i 表示最后一个不重复元素的位置
        for (int j = 1; j < L; ++j) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicatesV2(int[] nums) {
        final int L = nums.length;
        if (L < 2) {
            return L;
        }
        int i = 0;
        for (int j = 1; j < L; ++j) {
            if (nums[i] != nums[j]) {
                ++i;
                if (i < j) {
                    ArrayUtil.swap(nums, i, j);
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9}));
        System.out.println(solu.removeDuplicates(new int[] {2, 2, 2, 11}));
    }
}