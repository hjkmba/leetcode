package tag.greedy;

/**
 * Created by he.dong on 10/23/2017.
 */
public class _392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0; i < t.length() - s.length() + 1; i++) {
            if (s.charAt(0) == t.charAt(i)) {
                int count = 0;
                for (int j = 0; j < t.length() - i && count < s.length(); j++) {
                    if (s.charAt(count) == t.charAt(i + j))
                        count++;
                }
                if (count == s.length())
                    return true;
            }
        }
        return false;
    }
}
