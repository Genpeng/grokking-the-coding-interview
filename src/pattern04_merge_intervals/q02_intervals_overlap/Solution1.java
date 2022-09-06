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
 * Tags: array;
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

    public boolean isOverlappingV2(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return false;
        }
        final int N = intervals.length;
        int[][] points = new int[N << 1][2];
        for (int i = 0; i < N; ++i) {
            points[2 * i] = new int[] {intervals[i][0], 1};
            points[2 * i + 1] = new int[] {intervals[i][1], -1};
        }
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        int currNum = 0, maxNum = 0;
        for (int i = 0; i < points.length; ++i) {
            currNum += points[i][1];
            maxNum = Math.max(currNum, maxNum);
            if (maxNum >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.isOverlappingV2(new int[][] {{1, 4}, {2, 5}, {7, 9}}));
    }
}