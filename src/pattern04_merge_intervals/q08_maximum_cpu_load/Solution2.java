package pattern04_merge_intervals.q08_maximum_cpu_load;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 * <p>
 * Example 1:
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 * <p>
 * Example 2:
 * Jobs: [[6,7,10], [2,4,11], [8,12,15]]
 * Output: 15
 * Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
 * <p>
 * Example 3:
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;sweep line algorithm
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 解法二：堆
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     *
     * @param jobs int[], a list of triplets where each triplet contains a start time, an end time and
     *             its CPU load
     * @return int, the maximum CPU load at any time
     */
    public int maxCpuLoad(int[][] jobs) {
        if (jobs == null) {
            return 0;
        }
        final int N = jobs.length;
        if (N < 2) {
            return jobs[0][2];
        }
        Arrays.sort(jobs, (j1, j2) -> (j1[0] - j2[0])); // ⚠️ 任务必须是有序的
        int currLoad = 0, maxLoad = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(N, (j1, j2) -> (j1[1] - j2[1]));
        for (int[] job : jobs) {
            while (!pq.isEmpty() && job[0] >= pq.peek()[1]) {
                currLoad -= pq.poll()[2];
            }
            pq.offer(job);
            currLoad += job[2];
            maxLoad = Math.max(maxLoad, currLoad);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.maxCpuLoad(new int[][] {{1, 4, 3}, {2, 5, 4}, {7, 9, 6}})); // 7
        System.out.println(solu.maxCpuLoad(new int[][] {{6, 7, 10}, {2, 4, 11}, {8, 12, 15}})); // 15
        System.out.println(solu.maxCpuLoad(new int[][] {{1, 4, 2}, {2, 4, 1}, {3, 6, 5}})); // 8
        System.out.println(solu.maxCpuLoad(new int[][] {{12, 14, 3}, {10, 12, 4}})); // 4
    }
}