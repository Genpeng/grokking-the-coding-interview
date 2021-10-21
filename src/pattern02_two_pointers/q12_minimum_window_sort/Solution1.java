package pattern02_two_pointers.q12_minimum_window_sort;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * <p>
 * Example 1:
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * <p>
 * Example 2:
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * <p>
 * Example 3:
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * <p>
 * Example 4:
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int li = 0, ri = n - 1;
        // Step 1: find out the first element out of sorting order
        while (li < n - 1 && nums[li] <= nums[li + 1]) {
            ++li;
        }
        if (li == n - 1) {
            return 0;
        }
        // Step 2: find out the last element out of sorting order
        while (ri > 0 && nums[ri] >= nums[ri - 1]) {
            --ri;
        }
        // Step 3: find the minimum and maximum in the subarray
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = li; i <= ri; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // Step 4: extend the subarray to include any number which is bigger than the minimum of the subarray
        while (li > 0 && nums[li - 1] > min) {
            --li;
        }
        // Step 5: extend the subarray to include any number which is smaller than the maximum of the subarray
        while (ri < n - 1 && nums[ri + 1] < max) {
            ++ri;
        }
        return ri - li + 1;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}) == 5);
        System.out.println(solu.sort(new int[]{1, 3, 2, 0, -1, 7, 10}) == 5);
        System.out.println(solu.sort(new int[]{1, 2, 3}) == 0);
        System.out.println(solu.sort(new int[]{3, 2, 1}) == 3);
    }
}