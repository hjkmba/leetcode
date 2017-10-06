package tag.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by he.dong on 10/6/2017.
 */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null)
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1 );
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= (nums.length+1)/2 )
                return entry.getKey();
        }

        return -1;
        // other solutions
            // sorting, and take n+1/2 element
            // hash map, as above
            // bit manipulate  --> ignored for now
    }
}
