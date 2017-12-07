package tag.undefined;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by he.dong on 10/27/2017.
 */
public class _84_LargestRectangleInHistgram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length ==0)
            return 0;
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int n : heights) {
            sortedSet.add(n);
        }
        int i = 0;
        int[] area = new int[sortedSet.size()];

        for (int n : sortedSet) {
            int count = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= n) {
                    count++;
                } else {
                    int val = count * n;
                    area[i] = area[i] < val ? val : area[i];
                    count = 0;
                }
            }
            area[i] = area[i] < count * n ? count * n : area[i];
            i++;
        }
        int max = 0 ;
        for (int j = 0; j < area.length; j++) {
            if (area[j] > max)
                max = area[j];
        }
        return max;
    }

    public int largestRectangleAreaWithBetterPerformance(int[] heights) {
        int maxArea = 0;
        Stack<Integer> tracking = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (tracking.isEmpty() || tracking.peek() < heights[i]) {
                tracking.push(heights[i]);
                count.push(i);
            } else if (tracking.peek() > heights[i]) {
                int pos = 0;
                while (!tracking.isEmpty() && tracking.peek() > heights[i]) {
                    pos = count.peek();
                    int area = tracking.pop() * (i - count.pop());
                    maxArea = maxArea < area ? area : maxArea;
                }
                tracking.push(heights[i]);
                count.push(pos);
            }
        }
        while (!tracking.isEmpty()) {
            int area = tracking.pop() * (heights.length - count.pop());
            maxArea = maxArea < area ? area : maxArea;
        }

        return maxArea;
    }


    public int getMaxArea(int hist[], int n)
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false)
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }


    public static void main(String[] args) {
//        System.out.println(new _84_LargestRectangleInHistgram().largestRectangleAreaWithBetterPerformance(new int[]{1,2,2,2,1}));
        System.out.println(new _84_LargestRectangleInHistgram().getMaxArea(new int[]{1, 2, 2, 2, 1,3}, 6));
    }
}
