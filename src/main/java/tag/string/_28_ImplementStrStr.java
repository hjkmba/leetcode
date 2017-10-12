package tag.string;

/**
 * Created by he.dong on 10/12/2017.
 */
public class _28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length()<needle.length())
            return -1;
        if (haystack.length()== needle.length())
            return haystack.equals(needle) ? 0 : -1;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        return -1;
    }
}
