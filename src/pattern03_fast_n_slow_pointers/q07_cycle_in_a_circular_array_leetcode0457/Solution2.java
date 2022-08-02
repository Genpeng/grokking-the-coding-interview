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
public class Solution2 {
    /**
     * 判断循环数组中是否存在环（从某个位置出发，经过有限次跳跃，可以回到起点）
     * 环的限制条件：
     * - 元素的数量 > 1
     * - 方向唯一，只能有一个方向
     *
     * 解题思路：气味标记法，类似动物寻找食物，标记领地的过程
     * - 每次从一个点出发，不断向下一个位置跳跃，如果中间有一个点不满足环的条件（方向不唯一或者原地跳跃），
     *   则该点不是环的一个组成元素（即这条路径不存在环）
     * - 向下一个位置跳跃的过程可以采用递归进行实现，同时，用一个辅助数组标记每一次寻找过的路径（不同的值代表不同的寻找轮次）
     *
     * 复杂度分析：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
     *
     * @param nums int[], integer array
     * @return boolean, true if the array has a cycle
     */
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        final int L = nums.length;
        int[] visited = new int[L];
        for (int i = 0; i < nums.length; ++i) {
            if (existsLoop(nums, visited, nums[i] > 0, i + 1, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean existsLoop(int[] nums, int[] visited, boolean forward, int flag, int idx) {
        // 如果是已经有寻找过的位置，看看是否是同一轮的
        if (visited[idx] > 0) {
            return visited[idx] == flag;
        }
        // 判断是否为同一方向
        boolean isSameDirection = (nums[idx] > 0) == forward;
        if (!isSameDirection) {
            return false;
        }
        // 计算下一个位置
        int nextIdx = (idx + nums[idx]) % nums.length;
        if (nextIdx < 0) {
            nextIdx += nums.length;
        }
        // 如果在原地跳跃，返回 false
        if (nextIdx == idx) {
            return false;
        }
        // 如果是没有寻找过的位置，标记一下
        visited[idx] = flag;
        return existsLoop(nums, visited, forward, flag, nextIdx);
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.circularArrayLoop(new int[] {-1, 2, 1, 2}));
    }
}