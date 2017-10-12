package tag.string;

/**
 * Created by he.dong on 10/12/2017.
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        String s = "";
        if (a.length() < b.length()) {
            s = a;
            a = b;
            b = s;
        }
        s = "";
        int len = a.length();
        int gap = a.length() - b.length();
        int inc = 0;
        for (int i = len-1, j = len - 1 - gap; i >= 0; i--, j--) {
            int sum;
            if (j>=0){
                sum = inc + Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j));
            } else {
                sum = inc + Character.getNumericValue(a.charAt(i));
            }
            if (sum >= 2){
                inc = 1;
                s = sum%2 + s;
            } else {
                inc = 0;
                s = String.valueOf(sum) + s;
            }
        }
        if (inc == 1)
            return "1" + s;
        return s;
    }

    public String betterCode(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum;
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i>=0)
                sum += a.charAt(i--) - '0';
            if (j>=0)
                sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry>0)
            sb.append("1");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _67_AddBinary().addBinary("11","1"));
    }
}
