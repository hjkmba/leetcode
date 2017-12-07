package tag.sorting;

import java.util.Arrays;

/**
 * Created by he.dong on 11/7/2017.
 */
public class SelectingSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{2, 3, 1, 4, 4, 4, 5, 9}, {0}, {2, 1}, {},{0,0,0}};
        Sort sort = new SelectingSort();
        for (int[] d : data) {
            sort.sort(d);
        }
    }
}
