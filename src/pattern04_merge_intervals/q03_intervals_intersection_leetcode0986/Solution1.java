package pattern04_merge_intervals.q03_intervals_intersection_leetcode0986;

import java.util.ArrayList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals
 * sorted on their start time.
 *
 * Example 1:
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 * Example 2:
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int firstL = firstList[i][0], firstR = firstList[i][1];
            int secondL = secondList[j][0], secondR = secondList[j][1];
            // 如果存在交集，存到结果列表中
            if ((firstL >= secondL && firstL <= secondR) || (secondL >= firstL && secondL <= firstR)) {
                result.add(new int[] {Math.max(firstL, secondL), Math.min(firstR, secondR)});
            }
            if (firstR <= secondR) {
                ++i;
            } else {
                ++j;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] intervalIntersectionV2(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int L, R;
        while (i < firstList.length && j < secondList.length) {
            L = Math.max(firstList[i][0], secondList[j][0]);
            if (firstList[i][1] <= secondList[j][1]) {
                R = firstList[i][1];
                ++i;
            } else {
                R = secondList[j][1];
                ++j;
            }
            if (L > R) {
                continue;
            }
            result.add(new int[] {L, R});
        }
        return result.toArray(new int[result.size()][2]);
    }
}