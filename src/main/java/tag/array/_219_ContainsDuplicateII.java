package tag.array;

import java.util.*;

/**
 * Created by DHunter on 2017/10/7.
 */
public class _219_ContainsDuplicateII {
    // time limit exceed
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j <= k && i+j < nums.length; j++) {
                if (nums[i] == nums[i+j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> index = entry.getValue();
            if (index.size() > 1) {
                for (int i = 0; i < index.size() - 1; i++) {
                    for (int j = i + 1; j < index.size(); j++) {
                        if (Math.abs(index.get(i) - index.get(j)) <= k) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean betterAnswer(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
