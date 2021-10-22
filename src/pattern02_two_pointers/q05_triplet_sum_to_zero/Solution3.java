package pattern02_two_pointers.q05_triplet_sum_to_zero;

import java.util.Arrays;
import java.util.LinkedList;
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
public class Solution3 {
    /**
     * 解法3：双指针
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums int[], input array of unsorted numbers
     * @return List<List<Integer>>, all triplets whose sum is equal to zero
     */
    public List<List<Integer>> searchTriplets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> triplets = new LinkedList<>();
        if (n < 3) {
            return triplets;
        }
        Arrays.parallelSort(nums);
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            searchPairs(nums, -nums[i], i + 1, n - 1, triplets);
        }
        return triplets;
    }

    private void searchPairs(int[] nums, int target, int li, int ri, List<List<Integer>> triplets) {
        int s;
        while (li < ri) {
            s = nums[li] + nums[ri] - target;
            if (s == 0) {
                triplets.add(Arrays.asList(-target, nums[li], nums[ri]));
                while (li < ri && nums[li] == nums[li + 1]) {
                    ++li;
                }
                while (li < ri && nums[ri] == nums[ri - 1]) {
                    --ri;
                }
                ++li;
                --ri;
            } else if (s < 0) {
                ++li;
            } else { // s > 0
                --ri;
            }
        }
    }
}