package pattern03_fast_n_slow_pointers.q07_cycle_in_a_circular_array_leetcode0457;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’
 * at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative
 * move backwards ‘M’ indices. You should assume that the array is circular which means two things:
 *
 * - If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 * - If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 *
 * Write a method to determine if the array has a cycle. The cycle should have more than one element
 * and should follow one direction which means the cycle should not contain both forward and backward movements.
 *
 * Example 1:
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 *
 * Example 2:
 * Input: [2, 2, -1, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
 *
 * Example 3:
 * Input: [2, 1, -1, -2]
 * Output: false
 * Explanation: The array does not have any cycle.
 * ==========================================================================================================
 * <p>
 * Difficulty: Hard
 * Tags: array; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 判断循环数组中是否存在环（从某个位置出发，经过有限次跳跃，可以回到起点）
     * 环的限制条件：
     * - 元素的数量 > 1
     * - 方向唯一，只能有一个方向
     *
     * 解题思路：
     * 快慢指针（fast & slow pointers）
     *
     * @param nums int[], integer array
     * @return boolean, true if the array has a cycle
     */
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; ++i) {
            boolean isForward = nums[i] >= 0;
            int slow = i, fast = i;
            do {
                slow = findNextIndex(nums, isForward, slow);
                fast = findNextIndex(nums, isForward, fast);
                if (fast != -1) {
                    fast = findNextIndex(nums, isForward, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);
            if (fast != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int findNextIndex(int[] arr, boolean isForward, int idx) {
        boolean direction = arr[idx] >= 0;
        if (direction != isForward) {
            return -1;
        }
        int nextIdx = (idx + arr[idx]) % arr.length;
        if (nextIdx < 0) {
            nextIdx += arr.length;
        }
        if (nextIdx == idx) {
            return -1;
        }
        return nextIdx;
    }
}