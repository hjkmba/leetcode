package tag.string;

/**
 * Created by he.dong on 12/15/2017.
 */
public class _151_ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        s = s.replaceAll("[ ]+", " ");

        String[] words = s.split("[ ]");
        String ss = "";
        for (int i = words.length-1; i >0 ; i--) {
            ss += words[i] + " ";
        }
        ss += words[0];

        return ss;
    }

    public static void main(String[] args) {
        System.out.println(new _151_ReverseWordsInAString().reverseWords("    "));
        System.out.println(new _151_ReverseWordsInAString().reverseWords("aa     cc"));
    }
}
