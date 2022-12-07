package pattern05_cyclic_sort.q01_cyclic_sort;

import utils.ArrayUtil;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * We are given an array containing n objects. Each object, when created, was assigned a unique number
 * from the range 1 to n based on their creation sequence. This means that the object with
 * sequence number 3 was created just before the object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * and without using any extra space. For simplicity, let’s assume we are passed an integer array
 * containing only the sequence numbers, though each number is actually an object.
 *
 * Example 1:
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 *
 * Example 2:
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 *
 * Example 3:
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
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
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums int[], an input integer array represents create sequence numbers of objects
     */
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1; // 实际应该放置的位置
            if (nums[i] != nums[j]) { // 📢 为什么条件不是 nums[i]-1 != i？
                ArrayUtil.swap(nums, i, j);
            } else {
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 5, 4, 2};
        int[] nums2 = {2, 6, 4, 3, 1, 5};
        int[] nums3 = {1, 5, 6, 4, 3, 2};
        Solution1.sort(nums1);
        Solution1.sort(nums2);
        Solution1.sort(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}