package tag.tree;

/**
 * Created by he.dong on 12/18/2017.
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return generateTree(nums, 0, nums.length - 1);
        }

        public TreeNode generateTree(int[] nums, int start, int end) {
            if (start > end)
                return null;

            int loc = (end + start) / 2;
            TreeNode root = new TreeNode(nums[loc]);
            root.left = generateTree(nums, start, loc-1);
            root.right = generateTree(nums, loc + 1, end);
            return root;
        }
    }
}
