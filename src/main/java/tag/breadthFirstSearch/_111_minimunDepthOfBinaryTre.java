package tag.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by he.dong on 10/18/2017.
 */
public class _111_minimunDepthOfBinaryTre {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.right==null && t.left == null)
                return t.val;

            if (t.left != null){
                t.left.val = t.val + 1;
                queue.offer(t.left);
            }
            if (t.right != null){
                t.right.val = t.val + 1;
                queue.offer(t.right);
            }
        }
        return -1;
    }

    public int minDepthByDfs(TreeNode root) {
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode tree) {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return 1;
        if (tree.left == null)
            return getMinDepth(tree.right) + 1;
        else if (tree.right == null)
            return getMinDepth(tree.left) + 1;
        else
            return Math.min(getMinDepth(tree.left), getMinDepth(tree.right)) + 1;
    }



}
