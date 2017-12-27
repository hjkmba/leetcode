package tag.dynamicProgramming;

/**
 * Created by he.dong on 11/9/2017.
 */
public class LongestCommonSubString {
    public int longest(String s1, String s2) {
        return getLong(s1, s2, "");
    }

    private int getLong(String s1, String s2, String substr) {
        if (s1.length() == 0 || s2.length() == 0) {
            System.out.println(substr);
            return 0;
        }

        if (s1.length() == 1 && s2.length() == 1) {
            if (s1.equals(s2)) {
                System.out.println(s1 + substr);
                return 1;
            } else {
                System.out.println(substr);
                return 0;
            }
        }
        char c1 = s1.charAt(s1.length() - 1);
        char c2 = s2.charAt(s2.length() - 1);
        if (c1 == c2) {
            return getLong(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), c1 + substr) + 1;
        } else {
            return Math.max(getLong(s1.substring(0, s1.length() - 1), s2, substr), getLong(s1, s2.substring(0, s2.length() - 1), substr));
        }
    }


    public void getLongestByLoop(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] len = new int[c1.length][c2.length];
        int[][] path = new int[c1.length][c2.length];

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[0]) {
                len[i][0] = 1;
                path[i][0] = 1;
            }
        }

        for (int i = 0; i < c2.length; i++) {
            if (c2[i] == c1[0]) {
                len[0][i] = 1;
                path[0][i] = 1;
            }
        }

        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if (c2[j] == c1[i]) {
                    len[i][j] = len[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                } else if (len[i - 1][j] >= len[i][j - 1]){
                    len[i][j] = len[i - 1][j];
                    path[i][j] = 2;
                } else {
                    len[i][j] = len[i][j-1];
                    path[i][j] = 3;
                }
            }
        }
        System.out.println(len[c1.length-1][c2.length-1]);
        System.out.println(getPath(c1, c2, path, c1.length - 1, c2.length - 1));
    }

    private String getPath(char[] c1, char[] c2, int[][] path, int i, int j) {
        if (i < 0 || j<0)
            return "";
        if (path[i][j] == 1) {
            return getPath(c1, c2, path, i - 1, j - 1) + c1[i];
        } else if (path[i][j] == 2) {
            return getPath(c1, c2, path, i - 1, j);
        } else {//
            return getPath(c1, c2, path, i, j - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new LongestCommonSubString().longest("abcdefg", "ecfgdfed"));
//        System.out.println(new LongestCommonSubString().longest("abcdefg", "ecfgdfefd"));

        new LongestCommonSubString().getLongestByLoop("abcdefg", "ecfgdfed");
        new LongestCommonSubString().getLongestByLoop("abcdefg", "edcefgdfefd");
        Class<?> a = null;

    }
}
