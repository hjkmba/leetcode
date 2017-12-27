package tag.string;

import java.util.Stack;

/**
 * Created by he.dong on 12/15/2017.
 */
public class _606_ConstructStringFromBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2strRecursion(TreeNode t) {
        return preOrder(t);
    }


    public String preOrder(TreeNode treeNode) {
        if (treeNode == null)
            return "";
        String left = preOrder(treeNode.left);
        String right = preOrder(treeNode.right);
        if (left.equals("") && right.equals(""))
            return treeNode.val+"";
        if (!right.equals("")) {
            return treeNode.val + "(" + left + ")(" + right + ")";
        } else {
            return treeNode.val + "(" + left + ")";
        }
    }

    public String tree2str(TreeNode t) {
        String s = "";
        if (t == null)
            return s;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == -111111) {
                s += ")";
            } else if (node.val == -222222) {
                s += "(";
            } else {
                s += node.val;
                if (node.right == null && node.left == null) {
                    continue;
                }
                if (node.right != null) {
                    stack.push(new TreeNode(-111111));
                    stack.push(node.right);
                    stack.push(new TreeNode(-222222));
                }

                stack.push(new TreeNode(-111111));
                if(node.left !=null)
                    stack.push(node.left);
                stack.push(new TreeNode(-222222));
            }
        }
        return s;
    }

}
