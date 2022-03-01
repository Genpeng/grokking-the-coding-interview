package pattern02_two_pointers.q04_squaring_a_sorted_array;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a sorted array, create a new array containing squares of all the numbers of the input array
 * in the sorted order.
 * <p>
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * <p>
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: array;fast & slow pointers;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int[] makeSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        final int L = nums.length;
        int[] squares = new int[L];
        if (nums[0] >= 0) {
            // 优化点
            for (int i = 0; i < L; ++i) {
                squares[i] = nums[i] * nums[i];
            }
        } else {
            int li = 0, ri = L - 1, k = L - 1;
            while (li <= ri) { // 注意：此处是等号，不然会缺少一个元素
                if (Math.abs(nums[li]) < Math.abs(nums[ri])) {
                    squares[k] = nums[ri] * nums[ri];
                    --ri;
                } else {
                    squares[k] = nums[li] * nums[li];
                    ++li;
                }
                --k;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(Arrays.toString(solu.makeSquares(new int[]{-2, -1, 0, 2, 3})).equals("[0, 1, 4, 4, 9]"));
        System.out.println(Arrays.toString(solu.makeSquares(new int[]{-3, -1, 0, 1, 2})).equals("[0, 1, 1, 4, 9]"));
        System.out.println(Arrays.toString(solu.makeSquares(new int[]{-3, -1, 1, 1, 2})).equals("[1, 1, 1, 4, 9]"));
    }
}