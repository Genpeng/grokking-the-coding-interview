package pattern02_two_pointers.q07_triplets_with_smaller_sum;

import java.util.Arrays;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * <p>
 * Example 2:
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int searchTriplets(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) {
            return count;
        }
        Arrays.parallelSort(nums);
        final int L = nums.length;
        for (int i = 0; i < L - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int li = i + 1, ri = L - 1;
            int diff;
            while (li < ri) {
                diff = target - nums[i] - nums[li] - nums[ri];
                if (diff > 0) {
                    count += ri - li;
                    ++li;
                } else { // diff <= 0
                    --ri;
                }
            }
        }
        return count;
    }

    public int searchTripletsV2(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) {
            return count;
        }
        Arrays.parallelSort(nums);
        final int L = nums.length;
        for (int i = 0; i < L - 2; ++i) {
            count += countPairLessThanTarget(nums, target - nums[i], i+1, L-1);
        }
        return count;
    }

    private int countPairLessThanTarget(int[] nums, int target, int li, int ri) {
        int count = 0;
        while (li < ri) {
            int diff = target - nums[li] - nums[ri];
            if (diff > 0) {
                count += (ri - li);
                ++li;
            } else {
                --ri;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.searchTriplets(new int[]{-1, 0, 2, 3}, 3) == 2);
        System.out.println(solu.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5) == 4);
    }
}