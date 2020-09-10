package com.song.leetcode.leetcode.answer;

import javax.swing.tree.TreeNode;

/**
 * @ClassName MirrorOrNot
 * @Description TODO
 * @Author songyp
 * @Date 2019-12-23 10:31
 * @Version 1.0.0
 * 判断一个二叉树是不是镜像二叉树
 */
public class MirrorOrNot {
    public Boolean isMirror(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }

    public Boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left != null && right != null) {
            return mirror(left.left, right.right) && mirror(left.right, right.right);
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
