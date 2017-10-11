package tag.array;

import java.util.*;

/**
 * Created by he.dong on 10/9/2017.
 */
public class _414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2)
                    return 0;
                else if (o1>o2)
                    return -1;
                else
                    return 1;
            }
        });
        for (int a : nums) {
            pq.offer(a);
        }
        System.out.println(pq);
        int max = pq.poll();
        int third = -99999999;
        int prev = max;
        int distinctCount = 0;
        while (!pq.isEmpty() && distinctCount<2) {
            third = pq.poll();
            if (third == prev) {
                continue;
            } else {
                prev = third;
                distinctCount++;
            }
        }
        if (distinctCount == 2)
            return third;
        else
            return max;
    }



    public static void main(String[] args) {
        System.out.println(new _414_ThirdMaximumNumber().thirdMax(new int[]{-2147483648, 0, 0}));
        System.out.println(new _414_ThirdMaximumNumber().thirdMax(new int[]{2147483647, -1, -1}));

    }
}
