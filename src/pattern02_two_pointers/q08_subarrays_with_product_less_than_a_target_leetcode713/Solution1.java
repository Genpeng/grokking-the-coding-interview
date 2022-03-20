package pattern02_two_pointers.q08_subarrays_with_product_less_than_a_target_leetcode713;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose
 * product is less than the target number.
 * <p>
 * Example 1:
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * <p>
 * Example 2:
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public List<List<Integer>> findSubarrays(int[] nums, int target) {
        List<List<Integer>> subarrays = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return subarrays;
        }
        final int L = nums.length;
        int product = 1;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            product *= nums[ri];
            while (li <= ri && product >= target) {
                product /= nums[li++];
            }
            LinkedList<Integer> subarray = new LinkedList<>();
            for (int i = ri; i >= li; --i) {
                subarray.addFirst(nums[i]);
                subarrays.add(new LinkedList<>(subarray));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.findSubarrays(new int[]{2, 5, 3, 10}, 30)); // [2], [5], [2, 5], [3], [5, 3], [10]
        System.out.println(solu.findSubarrays(new int[]{8, 2, 6, 5}, 50)); // [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
    }
}