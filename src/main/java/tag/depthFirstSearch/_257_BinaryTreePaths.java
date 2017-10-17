package tag.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by he.dong on 10/17/2017.
 */
public class _257_BinaryTreePaths {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        return getPath(root);
    }

    public ArrayList<String> getPath(TreeNode tree) {
        if (tree == null)
            return new ArrayList<>();
        if (tree.left == null && tree.right == null) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(String.valueOf(tree.val));
            return arr;
        } else {
            ArrayList<String> tail = getPath(tree.left);
            tail.addAll(getPath(tree.right));
            for (int i = 0; i < tail.size(); i++) {
                tail.set(i, tree.val + "->" + tail.get(i));
            }
            return tail;
        }
    }
}
