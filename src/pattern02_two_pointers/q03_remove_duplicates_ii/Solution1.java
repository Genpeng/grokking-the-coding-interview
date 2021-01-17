package pattern02_two_pointers.q03_remove_duplicates_ii;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place
 * and return the new length of the array.
 *
 * Example 1:
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 *
 * Example 2:
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;fast & slow pointers;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int removeDuplicates(int[] nums, int key) {
        int n = nums.length;
        int i = -1;
        for (int j = 0; j < n; ++j) {
            if (nums[j] != key) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.removeDuplicates(new int[] {1}, 1) == 0);
        System.out.println(solu.removeDuplicates(new int[] {1}, 0) == 1);
        System.out.println(solu.removeDuplicates(new int[] {3, 2, 3, 6, 3, 10, 9, 3}, 3) == 4);
        System.out.println(solu.removeDuplicates(new int[] {2, 11, 2, 2, 1}, 2) == 2);
    }
}