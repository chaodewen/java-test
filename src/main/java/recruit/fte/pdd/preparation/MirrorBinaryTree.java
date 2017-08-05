package recruit.fte.pdd.preparation;

import utils.TreeNode;

import java.util.Stack;

/**
 * Created by Cc on 2017/7/16.
 *
 * 求二叉树的镜像
 * Debug看结果
 */
public class MirrorBinaryTree {
    public TreeNode mirror(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = root.left, right = root.right;

        mirror(left);
        mirror(right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode mirrorNonRecursively(TreeNode root) {
        if(root == null)
            return root;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop(), left = cur.left, right = cur.right;

            cur.left = right;
            cur.right = left;

            if(left != null)
                stack.push(left);
            if(right != null)
                stack.push(right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);

        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();
//        mirrorBinaryTree.mirror(root);
        mirrorBinaryTree.mirrorNonRecursively(root);

        System.out.println(root);
    }
}