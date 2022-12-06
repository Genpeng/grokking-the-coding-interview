package pattern04_merge_intervals.q05_conflicting_appointments_leetcode0252_lintcode0920;

import java.util.Arrays;

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
 * Similar LintCode problem (920 Meeting Rooms):
 * https://www.lintcode.com/problem/920/
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean canAttendAll(int[][] A) {
        if (A == null || A.length < 2) {
            return true;
        }
        Arrays.sort(A, (i1, i2) -> (i1[0] - i2[0]));
//        Arrays.sort(A, Comparator.comparingInt(i -> i[0]));
        for (int i = 1; i < A.length; ++i) {
            if (A[i][0] < A[i-1][1]) {
                // 📢 注意：这里是 < 而不是 <=，因为这里是判断能否参加两个会议而不是判断是否有交集
                // 例如：[8, 10] 和 [10, 12] 不冲突
                return false;
            }
        }
        return true;
    }

    public boolean canAttendAllV2(int[][] A) {
        // ❗️注意：
        // 这道题如果用扫描线算法（Sweep Line Algorithm），需要传入的会议区间是有序的（按照会议的起始时间排序），
        // 例如：不能传入 [[12, 13], [10, 12]]，因为排序后的点为：[[10, 1], [12, 1], [12, -1], [13, -1]]
        if (A == null || A.length < 2) {
            return true;
        }
        int L = A.length;
        int[][] points = new int[L << 1][2];
        for (int i = 0; i < L; ++i) {
            points[2 * i] = new int[] {A[i][0], 1};
            points[2 * i + 1] = new int[] {A[i][1], -1};
        }
        Arrays.sort(points, (i1, i2) -> (i1[0] - i2[0]));
        int currNum = 0;
        for (int[] point : points) {
            currNum += point[1];
            if (currNum >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        boolean result1 = solu.canAttendAllV2(new int[][] {{1, 4}, {2, 5}, {7, 9}});
        boolean result2 = solu.canAttendAllV2(new int[][] {{6, 7}, {2, 4}, {8, 12}});
        boolean result3 = solu.canAttendAllV2(new int[][] {{12, 13}, {10, 12}});
        System.out.println(result1); // false
        System.out.println(result2); // true
        System.out.println(result3); // true
    }
}