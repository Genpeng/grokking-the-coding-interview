package pattern04_merge_intervals.q03_insert_interval_leetcode0057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are
 * also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
 * intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 * - 0 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= start_i <= end_i <= 10^5
 * - intervals is sorted by start_i in ascending order.
 * - newInterval.length == 2
 * - 0 <= start <= end <= 10^5
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        List<int[]> result = new ArrayList<>();
        final int N = intervals.length;
        int newLeft = newInterval[0], newRight = newInterval[1];
        // Step 1: 跳过不重叠的区间，并加入到结果列表中
        int i = 0;
        while (i < N && intervals[i][1] < newLeft) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            ++i;
        }
        // Step 2: 合并重叠的区间，并添加到结果列表中
        while (i < N && newRight >= intervals[i][0]) {
            newLeft = Math.min(newLeft, intervals[i][0]);
            newRight = Math.max(newRight, intervals[i][1]);
            ++i;
        }
        result.add(new int[] {newLeft, newRight});
        // Step 3: 添加剩余的区间
        while (i < N) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            ++i;
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        // 如果区间列表为空，将插入的区间加到列表的末尾，并返回
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        // 如果插入的区间在列表的末尾（左边界大于列表最后一个区间的右边界），则将插入的区间添加到列表的末尾，并返回
        final int N = intervals.length;
        int L = newInterval[0], R = newInterval[1];
        if (L > intervals[N-1][1]) {
            int[][] result = new int[N+1][2];
            for (int i = 0; i < N; ++i) {
                result[i] = new int[] {intervals[i][0], intervals[i][1]};
            }
            result[N] = new int[] {L, R};
            return result;
        }
        // 如果上述两种情况都不符合，找到需要插入的区间位置
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (L > intervals[i][1]) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            ++i;
        }
        // 合并重叠的区间
        while (i < N & R >= intervals[i][0]) {
            L = Math.min(L, intervals[i][0]);
            R = Math.max(R, intervals[i][1]);
            ++i;
        }
        result.add(new int[] {L, R});
        // 添加剩余的区间
        while (i < N) {
            result.add(new int[] {intervals[i][0], intervals[i][1]});
            ++i;
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] insertV3(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        List<int[]> result = new ArrayList<>();
        int L = newInterval[0], R = newInterval[1];
        boolean isInserted = false;
        for (int[] interval : intervals) {
            if (L > interval[1]) {
                result.add(interval);
            } else if (R >= interval[0]) {
                L = Math.min(L, interval[0]);
                R = Math.max(R, interval[1]);
            } else {
                if (!isInserted) {
                    result.add(new int[] {L, R});
                    isInserted = true;
                }
                result.add(interval);
            }
        }
        if (!isInserted) {
            result.add(new int[] {L, R});
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        int[][] result = solu.insertV3(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5}); // [[1,5],[6,9]]
//        int[][] result = solu.insertV3(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8}); // [[1,2],[3,10],[12,16]]
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}