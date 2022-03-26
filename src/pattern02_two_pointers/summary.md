
双指针适合在排序好的数组中查找目标值（比如：两数之和），模板如下：

```java
public class Solution {
    public List<List<Integer>> search(int[] nums, int target) {
        List<List<Integer>> tuples = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return tuples;
        }
        Arrays.sort(nums);
        final int L = nums.length;
        int li = 0, ri = L - 1;
        while (li < ri) {
            int diff = target - nums[li] - nums[ri];
            if (diff == 0) {
                Arrays.asList(nums[li], nums[ri]);
                while (li < ri && nums[li] == nums[li+1]) {
                    ++li;
                }
                while (li < ri && nums[ri] == nums[ri-1]) {
                    --ri;
                }
                ++li;
                --ri;
            } else if (diff < 0) { // target < nums[li] + nums[ri]
                --ri;
            } else { // target > nums[li] + nums[ri]
                ++li;
            }
        }
        return tuples;
    }
}
```
