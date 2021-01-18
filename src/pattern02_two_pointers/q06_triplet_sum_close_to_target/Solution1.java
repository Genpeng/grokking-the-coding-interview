package pattern02_two_pointers.q06_triplet_sum_close_to_target;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to
 * the target number as possible, return the sum of the triplet. If there are more than one such triplet, return
 * the sum of the triplet with the smallest sum.
 *
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 *
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 *
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int searchTriplet(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.parallelSort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int li = i + 1, ri = n - 1;
            int diff;
            while (li < ri) {
                diff = target - nums[i] - nums[li] - nums[ri];
                if (diff == 0) {
                    minDiff = diff;
                    break;
                }
                // diff != 0
                if (Math.abs(diff) < Math.abs(minDiff) || (Math.abs(diff) == Math.abs(minDiff) && diff > minDiff)) {
                    minDiff = diff;
                }
                if (diff > 0) {
                    ++li;
                } else {
                    --ri;
                }
            }
        }
        return target - minDiff;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.searchTriplet(new int[] {-2, 0, 1, 2}, 2) == 1);
        System.out.println(solu.searchTriplet(new int[] {-3, -1, 1, 2}, 1) == 0);
        System.out.println(solu.searchTriplet(new int[] {1, 0, 1, 1}, 100) == 3);
    }
}