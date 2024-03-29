package pattern04_merge_intervals.q08_maximum_cpu_load;

import java.util.Arrays;
import java.util.Comparator;

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
public class Solution1 {
    /**
     * 解法一：扫描线算法
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
        // 📢 注意：任务必须是有序的
        // 反例：[[12, 14, 3], [10, 12, 4]]，如果不是有序的，经过点的排序后，结果是 [[10, 4], [12, 3], [12, -4], [14, -3]]
        // 得到最大的 CPU 负载是 7，但是实际上 4
        Arrays.sort(jobs, (j1, j2) -> (j1[0] - j2[0]));
        int[][] points = new int[N << 1][2];
        for (int i = 0; i < N; ++i) {
            int start = jobs[i][0], end = jobs[i][1], cpuLoad = jobs[i][2];
            points[2 * i] = new int[] {start, cpuLoad};
            points[2 * i + 1] = new int[] {end, -cpuLoad};
        }
        Arrays.sort(points, (p1, p2) -> (p1[0] - p2[0]));
        int currCpuLoad = 0, maxCpuLoad = 0;
        for (int[] point : points) {
            currCpuLoad += point[1];
            maxCpuLoad = Math.max(maxCpuLoad, currCpuLoad);
        }
        return maxCpuLoad;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.maxCpuLoad(new int[][] {{1, 4, 3}, {2, 5, 4}, {7, 9, 6}})); // 7
        System.out.println(solu.maxCpuLoad(new int[][] {{6, 7, 10}, {2, 4, 11}, {8, 12, 15}})); // 15
        System.out.println(solu.maxCpuLoad(new int[][] {{1, 4, 2}, {2, 4, 1}, {3, 6, 5}})); // 8
        System.out.println(solu.maxCpuLoad(new int[][] {{12, 14, 3}, {10, 12, 4}})); // 4
    }
}