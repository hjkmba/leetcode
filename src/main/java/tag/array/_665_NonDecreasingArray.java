package tag.array;

import java.util.Map;

/**
 * Created by he.dong on 10/11/2017.
 */
public class _665_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int negCnt = 0;
        if (nums.length == 0)
            return true;
        int[] diff = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] < 0) {
                negCnt++;
                if (negCnt > 1)
                    return false;
                if ((i-1>=0 &&Math.abs(diff[i]) <= diff[i-1])
                        || (i+1<diff.length &&Math.abs(diff[i]) <= diff[i+1])
                        || i == 0
                        || i == diff.length-1)
                    continue;
                else
                    return false;
            }
        }

        return true;
    }

    public boolean betterSolution(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] > 0) {
                cnt++;
                if (i-2 < 0 || nums[i-2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }

        }

        return cnt <= 1;
    }
}
