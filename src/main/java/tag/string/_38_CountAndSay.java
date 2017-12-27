package tag.string;

/**
 * Created by he.dong on 12/18/2017.
 */
public class _38_CountAndSay {
    public String countAndSay(int n) {
        StringBuffer lastStr = new StringBuffer("1");
        int count = 0;
        while (n-- > 1) {
            StringBuffer newStr = new StringBuffer();
            count = 1;
            char c = lastStr.charAt(0);
            for (int i = 1; i < lastStr.length(); i++) {
                if (lastStr.charAt(i) == c) {
                    count++;
                } else{
                    newStr.append(String.valueOf(count)).append(c);
                    c = lastStr.charAt(i);
                    count = 1;
                }
            }
            newStr.append(String.valueOf(count)).append(c);
            lastStr = newStr;
        }

        return lastStr.toString();
    }
}
