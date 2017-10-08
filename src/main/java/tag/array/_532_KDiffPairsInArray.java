package tag.array;

import java.util.HashSet;

/**
 * Created by DHunter on 2017/10/8.
 */
public class _532_KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        int duplicated = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> dupSet = new HashSet<Integer>();
        for (int a : nums) {
            if (!set.add(a)) {
                if (!dupSet.contains(a)) {
                    dupSet.add(a);
                    duplicated++;
                }
            }
        }
        if (k == 0) {
            return duplicated;
        }
        int count = 0;
        for (int a : set) {
            if (set.contains(a - k) )
                count++;
            if (set.contains(a + k))
                count++;
        }
        return count/2;
    }
}
