package pattern02_two_pointers.q06_triplet_sum_close_to_target;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to
 * the target number as possible, return the sum of the triplet. If there are more than one such triplet, return
 * the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * <p>
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * <p>
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int searchTriplet(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("input array is illegal");
        }

        // sort the array
        Arrays.parallelSort(nums);

        final int L = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < L - 2; ++i) {
            int li = i + 1, ri = L - 1;
            while (li < ri) {
                int diff = target - nums[i] - nums[li] - nums[ri];
                if (diff == 0) {
                    minDiff = diff;
                    break;
                } else if (diff < 0) {
                    --ri;
                } else {
                    ++li;
                }
                // diff != 0
                if (Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
            }

            while (i < L - 2 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
        return target - minDiff;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.searchTriplet(new int[]{-2, 0, 1, 2}, 2) == 1);
        System.out.println(solu.searchTriplet(new int[]{-3, -1, 1, 2}, 1) == 0);
        System.out.println(solu.searchTriplet(new int[]{1, 0, 1, 1}, 100) == 3);
    }
}