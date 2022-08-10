package pattern04_merge_intervals.q02_intervals_overlap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a set of intervals, find out if any two intervals overlap.
 *
 * Example:
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: true
 * Explanation: Intervals [1,4] and [2,5] overlap
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: xxx;xxx;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean isOverlapping(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i-1][1] >= intervals[i][0]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.isOverlapping(new int[][] {{1, 4}, {2, 5}, {7, 9}}));
    }
}