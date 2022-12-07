package utils;

public class ArrayUtil {
    public static void swap(int[] nums, int i, int j) {
        if (nums == null) {
            return;
        }
        final int N = nums.length;
        if (i >= N || j >= N) {
            throw new IllegalArgumentException("index out of bound");
        }
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
