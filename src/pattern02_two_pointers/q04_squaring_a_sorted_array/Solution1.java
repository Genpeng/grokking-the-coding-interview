package pattern02_two_pointers.q04_squaring_a_sorted_array;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a sorted array, create a new array containing squares of all the numbers of the input array
 * in the sorted order.
 *
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;fast & slow pointers;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int[] makeSquares(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {};
        }
        int[] squares = new int[n];
        if (nums[0] >= 0) {
            for (int i = 0; i < n; ++i) {
                squares[i] = nums[i] * nums[i];
            }
        } else {
            int i = n - 1;
            int li = 0, ri = n - 1;
            while (li < ri) {
                if (Math.abs(nums[li]) < Math.abs(nums[ri])) {
                    squares[i] = nums[ri] * nums[ri];
                    --ri;
                } else {
                    squares[i] = nums[li] * nums[li];
                    ++li;
                }
                --i;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(Arrays.toString(solu.makeSquares(new int[] {-2, -1, 0, 2, 3})).equals("[0, 1, 4, 4, 9]"));
        System.out.println(Arrays.toString(solu.makeSquares(new int[] {-3, -1, 0, 1, 2})).equals("[0, 1, 1, 4, 9]"));
    }
}