package recruit.intern.toutiao.prepare;

import utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by Cc on 2017/8/16.
 *
 * Alibaba
 */
public class FindRegion {
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> ans = new ArrayList<>();
        search(ans, root, k1, k2);

        return ans;
    }
    private void search(ArrayList<Integer> ans, TreeNode root, int k1, int k2) {
        if(root == null)
            return;

        search(ans, root.left, k1, k2);

        if(root.val >= k1 && root.val <= k2)
            ans.add(root.val);

        search(ans, root.right, k1, k2);
    }
}