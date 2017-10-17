package tag.depthFirstSearch;

/**
 * Created by he.dong on 10/16/2017.
 */
public class _101_SymmetricTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

        } else {
            return false;
        }
    }
}
