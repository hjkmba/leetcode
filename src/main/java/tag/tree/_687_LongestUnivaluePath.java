package tag.tree;

/**
 * Created by he.dong on 12/19/2017.
 */
public class _687_LongestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        longest(root);
        return max;
    }

    public int longest(TreeNode t) {
        if (t == null)
            return 0;
        int left = longest(t.left);
        int right = longest(t.right);
        int leftPath = 0;
        int rightPath = 0;
        if (t.left != null && t.left.val == t.val)
            leftPath = 1 + left;
        if (t.right != null && t.right.val == t.val)
            rightPath = 1 + right;
        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }



}
