package tag.array;

import java.util.HashMap;

/**
 * Created by he.dong on 10/6/2017.
 */
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer expectedIndex = map.get(target-nums[i]);
            if (expectedIndex != null && expectedIndex != i ){
                return new int[]{i, expectedIndex};
            }
        }
        return null;
    }
}
