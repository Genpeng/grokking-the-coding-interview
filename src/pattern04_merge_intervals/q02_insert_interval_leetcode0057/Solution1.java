package pattern04_merge_intervals.q02_insert_interval_leetcode0057;

import java.util.ArrayList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are
 * also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and i
 * ntervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
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
 *
 * Constraints:
 * - 0 <= intervals.length <= 104
 * - intervals[i].length == 2
 * - 0 <= starti <= endi <= 105
 * - intervals is sorted by starti in ascending order.
 * - newInterval.length == 2
 * - 0 <= start <= end <= 105
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
}