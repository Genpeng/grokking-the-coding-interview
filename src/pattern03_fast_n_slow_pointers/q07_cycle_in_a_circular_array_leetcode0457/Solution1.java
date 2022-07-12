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
 * Write a method to determine if the array has a cycle.  which means the cycle should not contain both forward and backward movements.
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
    
}