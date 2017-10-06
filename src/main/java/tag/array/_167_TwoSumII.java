package tag.array;

import java.util.Arrays;

/**
 * Created by he.dong on 10/6/2017.
 */
public class _167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;
            if (numbers[i] <= target) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] + numbers[j] > target)
                        break;
                    if (numbers[i] + numbers[j] == target)
                        return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public int[] betterSolution(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }


        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        _167_TwoSumII solution = new _167_TwoSumII();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1,0}, -1)));
    }
}
