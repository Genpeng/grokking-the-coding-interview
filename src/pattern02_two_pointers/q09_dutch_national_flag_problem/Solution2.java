package pattern02_two_pointers.q09_dutch_national_flag_problem;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array
 * as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * <p>
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array
 * also consists of three different numbers that is why it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * <p>
 * Example 2:
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    public void dutchFlagSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int li = -1, ri = n; // li 表示最后一个存放 0 的位置索引，ri 表示第一个存放 2 的位置索引
        for (int i = 0; i < ri; ) { // 注意这里的终止条件 i < ri，>= ri 的位置都是摆放好的 2，所以不需要再进行调整
            if (nums[i] == 0) {
                ++li;
                if (i != li) {
                    swap(nums, li, i);
                }
                ++i;
            } else if (nums[i] == 2) {
                --ri;
                swap(nums, ri, i);
            } else {
                ++i;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        int[] a1 = new int[]{1, 0, 2, 1, 0};
        System.out.println(Arrays.toString(a1));
        solu.dutchFlagSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}