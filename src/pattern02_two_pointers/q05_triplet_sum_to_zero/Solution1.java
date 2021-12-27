package pattern02_two_pointers.q05_triplet_sum_to_zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example 1:
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * <p>
 * Example 2:
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;hash table;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：暴力解法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     *
     * @param nums int[], input array of unsorted numbers
     * @return List<List < Integer>>, all triplets whose sum is equal to zero
     */
    public List<List<Integer>> searchTriplets(int[] nums) {
        final int L = nums.length;
        if (L < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < L - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < L - 1; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < L; ++k) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int diff = -nums[i] - nums[j] - nums[k];
                    if (diff == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.searchTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2})); // [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(solu.searchTriplets(new int[] {-5, 2, -1, -2, 3})); // [[-5, 2, 3], [-2, -1, 3]]
    }
}