package tag.string;

/**
 * Created by he.dong on 10/12/2017.
 */
public class _686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuffer sb = new StringBuffer(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        while (true) {
            if (count > B.length()/A.length()+2)
                return -1;
            if (sb.indexOf(B) == -1) {
                sb.append(A);
                count++;
            } else
                return count;
        }
    }
}
