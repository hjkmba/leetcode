package tag.sorting;

import java.util.Arrays;

/**
 * Created by he.dong on 11/7/2017.
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[][] data = new int[][]{{2, 3, 1,9, 4, 4, 4, 5}, {0}, {2, 1}, {},{0,0,0}};
        Sort sort = new BubbleSort();
        for (int[] d : data) {
            sort.sort(d);
        }
    }
}
