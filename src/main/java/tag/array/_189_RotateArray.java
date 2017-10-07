package tag.array;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by DHunter on 2017/10/7.
 */
public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] rotatedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotatedNums[(i + k ) % nums.length] = nums[i];
        }
        for (int i = 0; i < rotatedNums.length; i++) {
            nums[i] = rotatedNums[i];
        }

        nums = rotatedNums;
        for (int a : nums) {
            System.out.print(a);
        }
        System.out.println();
    }

    public void rotate2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            queue.add(nums[i]);
        }
        while (k-- > 0) {
            queue.add(queue.remove());
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.remove());
        }

        System.out.println();
    }
    // there is a 3 reverse answer,
    // rotate(list, k) -> reverse(list, 0, list.length-1)
    //                  + reverse(list, 0, k-1)
    //                  + reverse(list, k, list.length-1 )

}
