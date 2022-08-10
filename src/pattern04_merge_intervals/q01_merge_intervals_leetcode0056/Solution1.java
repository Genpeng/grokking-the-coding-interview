package pattern04_merge_intervals.q01_merge_intervals_leetcode0056;

import java.util.*;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= starti <= endi <= 10^4
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 合并重叠的区间
     *
     * 输入限制：
     * - 1 <= 区间数量 <= 10^4
     * - 0 <= 区间左端点 <= 区间右断点 <= 10^4
     *
     * 解题思路：
     * - 将区间按照左边界进行排序，如果区间可以合并，那么这些可以合并的区间一定是连续的（可以用反证法证明）
     *
     * 知识点：
     * - Arrays.sort 是根据要排序的对象选择排序算法的，如果排序的对象是原生数据类型，则采用 Quicksort；
     *   如果排序的对象是非原生数据类型（例如 List），则采用 Timsort
     * - Quicksort 的时间复杂度为 O(N * logN)，空间复杂度为 O(logN)
     * - Timsort 的时间复杂度为 O(N * logN)，空间复杂度为 O(N)
     *
     * 复杂度分析：
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(logN)
     *
     * @param intervals int[][], an array of intervals
     * @return int[][], an array of non-overlapping intervals
     */
    public int[][] merge(int[][] intervals) {
        final int N = intervals.length;
        if (N < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < N; ++i) {
            int currLeft = intervals[i][0], currRight = intervals[i][1];
            if (currLeft <= right) {
                // 如果区间有重叠，合并区间
                right = Math.max(right, currRight);
            } else {
                // 如果区间没有重叠，保存上一次的区间，并更新需要比较的区间
                result.add(new int[] {left, right});
                left = currLeft;
                right = currRight;
            }
        }
        result.add(new int[] {left, right}); // 重要，记得保存最后的区间
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] mergeV2(int[][] intervals) {
        final int N = intervals.length;
        if (N < 2) {
            return intervals;
        }
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        // Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));  // 在 LeetCode 上，这种写法多耗时 2ms 左右
        for (int i = 0; i < N; ++i) {
            int currL = intervals[i][0], currR = intervals[i][1];
            if (i == 0 || currL > result.getLast()[1]) {
                // 如果当前区间不重叠，则将当前区间加入到结果中
                result.add(new int[] {currL, currR});
            } else { // currL <= result.getLast()[1] && currL >= result.getLast()[0]
                // 如果当前区间重叠，则更新结果列表中最后一个区间
                result.getLast()[1] = Math.max(result.getLast()[1], currR);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.merge(new int[][] {{1, 4}, {0, 4}}));
    }
}