package com.song.leetcode;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/29
 * @description 二叉树对称
 * Laughter is poison to fear.
 */
public class Test {
    public static void main(String[] args) {

    }

    private Boolean duichen(Node node){
        if (node == null){
            return true;
        }
        if (node.left ==null ||node.right == null){
            return true;
        }
        if (node.left != node.right){
            return false;
        }
        return duichen(node.left)&&duichen(node.right);
    }

    private Boolean duichen2(Node node){
        if (node == null){
            return true;
        }
        Node left = node.left;
        Node right = node.right;
        return duichenMain(left,right);
    }

    private Boolean duichenMain(Node left, Node right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null ||right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return duichenMain(left.right,right.left) &&duichenMain(left.left,right.right);
    }


    class Node{
        int val;
        Node left;
        Node right;

    }
}
