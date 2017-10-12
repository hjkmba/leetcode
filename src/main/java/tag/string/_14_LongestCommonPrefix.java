package tag.string;

/**
 * Created by he.dong on 10/12/2017.
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length<=0)
            return "";
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length())
                shortest = s;
        }
        for (int i = shortest.length(); i > 0; i--) {
            String s = shortest.substring(0, i);
            int count = 0;
            for (String str : strs) {
                if (!str.startsWith(s))
                    break;
                count++;
            }
            if (count == strs.length)
                return s;
        }
        return "";
    }
}
