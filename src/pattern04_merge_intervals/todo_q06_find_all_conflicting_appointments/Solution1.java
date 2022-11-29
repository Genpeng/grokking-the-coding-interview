package pattern04_merge_intervals.todo_q06_find_all_conflicting_appointments;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a list of appointments, find all the conflicting appointments.
 *
 * Example:
 * Appointments: [[4,5], [2,3], [3,6], [5,7], [7,8]]
 * Output:
 * [4,5] and [3,6] conflict.
 * [3,6] and [5,7] conflict.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<List<Interval>> findConflictAppointments(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return new LinkedList<>();
        }
        LinkedList<List<Interval>> result = new LinkedList<>();
        int L = intervals.size();
        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        LinkedList<Interval> merged = new LinkedList<>();
        boolean startConflict = true;
        for (int i = 0; i < L; ++i) {
            int currL = intervals.get(i).start, currR = intervals.get(i).end;
            if (i == 0 || currL > merged.getLast().end) {
                merged.add(new Interval(currL, currR));
            } else {
                if (startConflict) {
                    merged.getLast().end = Math.max(merged.getLast().end, currR);
                    List<Interval> conflicts = new LinkedList<>();
                    conflicts.add(intervals.get(i-1));
                    conflicts.add(intervals.get(i));
                    result.add(conflicts);
                    startConflict = false;
                } else {
                    List<Interval> conflicts = result.getLast();
                }
            }
        }

        // TODO
        return null;
    }
}