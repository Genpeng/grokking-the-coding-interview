package pattern02_two_pointers.q10_quadruple_sum_to_target;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 *
 * Example 1:
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 *
 * Example 2:
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public List<List<Integer>> searchQuadruplets(int[] nums, int target) {
        List<List<Integer>> quadruplets = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 4; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j <= n - 3; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                searchPairs(nums, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private void searchPairs(int[] nums, int target, int first, int second, List<List<Integer>> quadruplets) {
        int li = second + 1, ri = nums.length - 1;
        while (li < ri) {
            int diff = target - nums[first] - nums[second] - nums[li] - nums[ri];
            if (diff == 0) {
                quadruplets.add(Arrays.asList(nums[first], nums[second], nums[li], nums[ri]));
                while (li < ri && nums[li] == nums[li+1]) {
                    ++li;
                }
                while (li < ri && nums[ri] == nums[ri-1]) {
                    --ri;
                }
                ++li;
                --ri;
            } else if (diff > 0) {
                ++li;
            } else { // diff < 0
                --ri;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.searchQuadruplets(new int[] {4, 1, 2, -1, 1, -3}, 1)); // [[-3, -1, 1, 4], [-3, 1, 1, 2]]
        System.out.println(solu.searchQuadruplets(new int[] {2, 0, -1, 1, -2, 2}, 2)); // [[-2, 0, 2, 2], [-1, 0, 1, 2]]

    }
}