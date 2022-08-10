package pattern04_merge_intervals.q05_conflicting_appointments;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 *
 * Example 1:
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 *
 * Example 2:
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 *
 * Example 3:
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean canAttendAll(int[][] A) {
        if (A == null || A.length < 2) {
            return true;
        }
        Arrays.sort(A, Comparator.comparingInt(i -> i[0]));
        for (int i = 1; i < A.length; ++i) {
            if (A[i-1][1] > A[i][0]) {
                // 📢 注意：这里是 > 而不是 >=，因为这里是判断能否参加两个会议，而不是判断是否有交集
                return false;
            }
        }
        return true;
    }
}