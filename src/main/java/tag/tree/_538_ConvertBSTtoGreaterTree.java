package tag.tree;

/**
 * Created by he.dong on 12/18/2017.
 */
public class _538_ConvertBSTtoGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
//            midOrder(root,0);
            reverseOrder(root);
            return root;
        }

        public void reverseOrder(TreeNode t) {
            if (t == null)
                return;
            reverseOrder(t.right);
            sum += t.val;
            System.out.println(t.val +" --> " + t.val+sum);
            t.val += sum;
            reverseOrder(t.left);
        }




        public void midOrder(TreeNode t, int parentSum) {
            if (t == null)
                return;
            int rightSum = nodeSum(t.right);
            midOrder(t.left, rightSum + t.val);
            System.out.print(t.val);
            t.val += parentSum + rightSum;
            System.out.println(" --> " + t.val);
            midOrder(t.right, 0);
        }

        public int nodeSum(TreeNode t) {
            if (t == null)
                return 0;
            return t.val + nodeSum(t.left) + nodeSum(t.right);
        }
    }

}
