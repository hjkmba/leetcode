package tag.sorting;

import java.util.Arrays;

/**
 * Created by he.dong on 11/7/2017.
 */
public class InsertingSort implements Sort{
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            int num = nums[i];
            while (j >= 0 && num < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = num;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{2, 3, 1, 4, 4, 4, 5, 9}, {0}, {2, 1}, {},{0,0,0}};
        Sort sort = new InsertingSort();
        for (int[] d : data) {
            sort.sort(d);
        }
    }
}
