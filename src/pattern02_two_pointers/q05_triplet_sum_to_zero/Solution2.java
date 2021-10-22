package pattern02_two_pointers.q05_triplet_sum_to_zero;

import java.util.*;

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
public class Solution2 {
    /**
     * 解法2：哈希表
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param nums int[], input array of unsorted numbers
     * @return List<List<Integer>>, all triplets whose sum is equal to zero
     */
    public List<List<Integer>> searchTriplets(int[] nums) {
        final int L = nums.length;
        if (L < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < L - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < L; ++j) {
                if (set.contains(nums[j])) {
                    triplets.add(Arrays.asList(nums[i], -nums[i]-nums[j], nums[j]));
                } else {
                    set.add(-nums[i]-nums[j]);
                }
            }
        }
        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.searchTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2})); // [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(solu.searchTriplets(new int[] {-5, 2, -1, -2, 3})); // [[-5, 2, 3], [-2, -1, 3]]
    }
}