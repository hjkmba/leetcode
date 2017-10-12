package tag.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by he.dong on 10/12/2017.
 */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (val > 0) {
                stack.push(val);
            } else if (stack.isEmpty() || stack.pop() + val != 0) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
