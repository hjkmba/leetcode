package tag.tree;

/**
 * Created by he.dong on 12/19/2017.
 */
public class _226_InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;
            TreeNode left = invertTree(root);
            TreeNode right = invertTree(root);

            root.right = left;
            root.left = right;

            return root;
        }
    }
}
