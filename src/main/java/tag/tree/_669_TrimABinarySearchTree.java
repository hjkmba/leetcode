package tag.tree;

import java.util.ArrayList;

/**
 * Created by he.dong on 12/18/2017.
 */
public class _669_TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        ArrayList<Integer> list = new ArrayList<>();
        generateArray(root, list, L, R);

        return generateTree(list);
    }

    public TreeNode generateTree(ArrayList<Integer> list) {
        if (list == null || list.size() == 0)
            return null;
        TreeNode t = new TreeNode(list.get(0));
        TreeNode p = t;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = new TreeNode(list.get(i));
            p.right = node;
            p = node;
        }
        return t;
    }

    public void generateArray(TreeNode root, ArrayList<Integer> list, int L, int R) {
        if (root == null)
            return;
        generateArray(root.left, list, L, R);
        if (root.val >= L && root.val <= R)
            list.add(root.val);
        generateArray(root.right, list, L, R);
    }

    public TreeNode propagate(TreeNode t, int l, int r) {
        if (t == null || l > r)
            return null;
        TreeNode left = propagate(t.left, l, r);
        TreeNode right = propagate(t.right, l, r);

        if (t.val < l)
            return right;
        if (t.val > r)
            return left;
        t.left = left;
        t.right = right;
        return t;

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