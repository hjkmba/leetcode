package tag.sorting;

import java.util.Arrays;

/**
 * Created by he.dong on 11/7/2017.
 */
public class QuickSort implements Sort{
    public void sort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quicksort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        } else {
            int pos = partition(nums, i, j);
            quicksort(nums, i, pos - 1);
            quicksort(nums, pos + 1, j);
            return;
        }

    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int[] nums, int i, int j) {
        int v = nums[j];
        int index = i;
        for (int k = i; k < j; k++) {
            if (nums[k] < v) {
                if (k!=index)
                    swap(nums, index, k);
                index++;
            }
        }
        swap(nums, index, j);
        return index;
    }
    public static void main(String[] args) {
        int[][] data = new int[][]{{2, 3, 1, 4, 4, 4, 5, 9}, {0}, {2, 1}, {},{0,0,0}};
        Sort sort = new QuickSort();
        for (int[] d : data) {
            sort.sort(d);
        }
    }
}
