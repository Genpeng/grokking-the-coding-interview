package pattern04_merge_intervals.q09_employee_free_time_leetcode0759;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * For ‘K’ employees, we are given a list of intervals representing each employee’s working hours.
 * Our goal is to determine if there is a free interval which is common to all employees. You can
 * assume that each list of employee working hours is sorted on the start time.
 *
 * Example 1:
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: All the employees are free between [3,5].
 *
 * Example 2:
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employees are free between [4,6] and [8,9].
 *
 * Example 3:
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employees are free between [5,7].
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: array; heap;
 *
 * Similar LintCode Problem (850. Employee Free Time)
 * https://www.lintcode.com/problem/850/
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 解法一：类似合并区间
     *
     * 复杂度分析：
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     *
     * @param schedule List<List<Interval>>, list of intervals representing each employee’s working hours
     * @return List<Interval>, list of finite intervals representing common, positive-length free time for all employees
     */
    public List<Interval> getEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            allIntervals.addAll(intervals);
        }
        List<Interval> result = new ArrayList<>();
        final int N = allIntervals.size();
        if (N < 2) {
            return result;
        }
        Collections.sort(allIntervals, (i1, i2) -> (i1.start - i2.start));
        int R = allIntervals.get(0).end;
        for (int i = 1; i < N; ++i) {
            Interval curr = allIntervals.get(i);
            if (curr.start > R) {
                result.add(new Interval(R, curr.start));
                R = curr.end;
            } else {
                R = Math.max(R, curr.end);
            }
        }
        return result;
    }
}