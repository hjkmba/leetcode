package tag.tree;

/**
 * Created by he.dong on 12/19/2017.
 */
public class _671_SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        int smaller = getSmaller(root, root.val);
        if (root.val == smaller)
            return -1;
        else
            return smaller;
    }

    public int getSmaller(TreeNode t, int val) {
        if (t == null)
            return val;
        if (t.val > val) {
            return t.val;
        } else {
            return getBiggerThan(getSmaller(t.left, val), getSmaller(t.right, val), val);
        }
    }

    public int getBiggerThan(int left, int right, int val) {
        if (left != val && right != val)
            return Math.min(left, right);
        else
            return Math.max(left, right);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
