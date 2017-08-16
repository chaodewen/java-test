package recruit.intern.toutiao.prepare;

import utils.TreeNode;

/**
 * Created by Cc on 2017/8/16.
 *
 * ByteDance
 */
public class FindProximal {
    public int closestValue(TreeNode root, double target) {
        if(target == root.val)
            return root.val;

        int val = root.val;

        if(target < root.val && root.left != null)
            val = closestValue(root.left, target);

        if(target < root.val && root.right != null)
            val = closestValue(root.right, target);

        return Math.abs(val - target) < Math.abs(root.val - target) ? val : root.val;
    }
}