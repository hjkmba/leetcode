package tag.breadthFirstSearch;

import java.util.*;

/**
 * Created by he.dong on 10/18/2017.
 */
public class _107_BinaryTreeLevelOrderTraversal_II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode margin = new TreeNode(0);
        queue.offer(root);
        queue.offer(margin);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.equals(margin)) {
                if (queue.isEmpty())
                    break;
                res.add(list);
                list = new ArrayList<>();
                queue.offer(margin);
            } else {
                list.add(t.val);
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);

            }
        }
        Collections.reverse(res);
        return res;
    }
}
