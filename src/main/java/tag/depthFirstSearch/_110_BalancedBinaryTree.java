package tag.depthFirstSearch;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by he.dong on 10/17/2017.
 */
public class _110_BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return true;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            TreeNode left = tree.left;
            TreeNode right = tree.right;
            if (!isBalanced(left,right))
                return false;
            if (left != null)
                stack.push(left);
            if (right != null)
                stack.push(right);
        }

        return true;
    }

    private boolean isBalanced(TreeNode left, TreeNode right) {
        return Math.abs(heightOfTree(left) - heightOfTree(right)) <= 1;
    }

    private int heightOfTree(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        if (map.containsKey(treeNode.hashCode()))
            return map.get(treeNode.hashCode());

        if (treeNode.left == null && treeNode.right == null){
            map.put(treeNode.hashCode(), 1);
            return 1;
        }
        int height = Math.max(heightOfTree(treeNode.left), heightOfTree(treeNode.right)) + 1;
        map.put(treeNode.hashCode(), height);
        return height;
    }

    public static void main(String[] args) {
        new _110_BalancedBinaryTree();

    }
}
