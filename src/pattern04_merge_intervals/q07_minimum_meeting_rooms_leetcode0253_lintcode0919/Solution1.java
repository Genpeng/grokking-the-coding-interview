package pattern04_merge_intervals.q07_minimum_meeting_rooms_leetcode0253_lintcode0919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of
 * rooms required to hold all the meetings.
 *
 * Example 1:
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 *
 * Example 2:
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 *
 * Example 3:
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 *
 * Example 4:
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * Similar LintCode Problem (911. Meeting Rooms II)
 * https://www.lintcode.com/problem/919/
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法一：扫描线算法（Sweep Line）
     *
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     *
     * @param meetings int[], a list of intervals representing the start and end time of ‘N’ meetings
     * @return int, the minimum number of rooms required to hold all the meetings
     */
    public int minMeetingRooms(int[][] meetings) {
        if (meetings == null) {
            return 0;
        }
        final int L = meetings.length;
        if (L < 2) {
            return L;
        }
        // 📢 注意：会议必须是有序的，即按照起始时间排序
        // 例如：[[12, 13], [10, 12]]，进行点的排序后，会变成：[[10, 1], [12, 1], [12, -1], [13, -1]]
        Arrays.sort(meetings, (m1, m2) -> (m1[0] - m2[0]));
        List<int[]> points = new ArrayList<>();
        for (int[] meeting : meetings) {
            points.add(new int[] {meeting[0], 1});
            points.add(new int[] {meeting[1], -1});
        }
        Collections.sort(points, (p1, p2) -> (p1[0] - p2[0]));
        int currNum = 0, maxNum = 0;
        for (int[] point : points) {
            currNum += point[1];
            maxNum = Math.max(maxNum, currNum);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.minMeetingRooms(new int[][] {{1, 4}, {2, 5}, {7, 9}})); // 2
        System.out.println(solu.minMeetingRooms(new int[][] {{6, 7}, {2, 4}, {8, 12}})); // 1
        System.out.println(solu.minMeetingRooms(new int[][] {{12, 13}, {10, 12}})); // 1
    }
}