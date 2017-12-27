package tag.string;

/**
 * Created by he.dong on 12/15/2017.
 */
public class _680_ValidPalindrome_II {
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length/2; i++) {
            if (c[i] != c[c.length - 1 - i]) {
                return isPalindrome(s, i + 1, c.length - 1 - i) || isPalindrome(s, i, c.length - 2 - i);
            }
        }
        return true;
    }


    private boolean isPalindrome(String s, int left, int right) {
        char[] c = s.substring(left, right+1).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - 1 - i])
                return false;
        }
        return true;
    }


//    private boolean isPalindrome(String s) {
//        char[] c = s.toCharArray();
//        for (int i = 0; i < c.length/2; i++) {
//            if (c[i] != c[c.length-i-1])
//                return false;
//        }
//        return true;
//    }



    public static void main(String[] args) {
        System.out.println(new _680_ValidPalindrome_II().validPalindrome("abc"));
        System.out.println(new _680_ValidPalindrome_II().validPalindrome("edddd"));
        System.out.println(new _680_ValidPalindrome_II().validPalindrome("eedede"));
    }
}
