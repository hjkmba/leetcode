package tag.array;

import java.util.Arrays;

/**
 * Created by he.dong on 10/11/2017.
 */
public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        int inc = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + inc == 10) {
                inc = 1;
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + inc;
                inc = 0;
            }
        }
        if (inc == 1) {
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            res[0] = inc;
            return res;
        } else
            return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _66_PlusOne().plusOne(new int[]{1,0})));
    }
}
