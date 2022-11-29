package pattern04_merge_intervals.q07_minimum_meeting_rooms_leetcode0253;

import java.util.*;

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
 * Tags: array; heap;
 *
 * Similar LintCode Problem (911. Meeting Rooms II)
 * https://www.lintcode.com/problem/919/
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 解法二：堆
     *
     * 思路：
     * 用一个堆（小顶堆）去模拟当前所有正在进行且有冲突的会议，当进来一个新的会议时，弹出堆中所有结束时间小于等于新会议起始时间
     * 的会议，则堆中此时存放的就是截止到当前时刻所有有冲突的会议，然后用一个变量保存所有时刻堆中会议数量的最大值，则该变量
     * 就是容纳所有会议需要的最少会议数量
     *
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     *
     * @param meetings int[], a list of intervals representing the start and end time of ‘N’ meetings
     * @return int, the minimum number of rooms required to hold all the meetings
     */
    public int minMeetingRooms(int[][] meetings) {
        // 问题1：排序的作用是什么？可以去掉吗？
        // 答：排序的作用对所有的时间间隔按照起始时间进行排序，可以方便比较间隔之间是否有重叠
        if (meetings == null) {
            return 0;
        }
        final int L = meetings.length;
        if (L < 2) {
            return L;
        }
        Arrays.sort(meetings, (m1, m2) -> (m1[0] - m2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(L, (m1, m2) -> (m1[1] - m2[1]));
        int minNum = 0;
        for (int[] meeting : meetings) {
            while (!pq.isEmpty() && meeting[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.offer(meeting);
            minNum = Math.max(minNum, pq.size());
        }
        return minNum;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.minMeetingRooms(new int[][] {{1, 4}, {2, 5}, {7, 9}})); // 2
        System.out.println(solu.minMeetingRooms(new int[][] {{6, 7}, {2, 4}, {8, 12}})); // 1
        System.out.println(solu.minMeetingRooms(new int[][] {{12, 13}, {10, 12}})); // 1
    }
}