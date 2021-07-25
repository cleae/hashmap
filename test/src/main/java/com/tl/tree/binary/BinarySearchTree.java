package com.tl.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * description: BinarySearchTree
 * created by lintan at 2020/12/8 10:17
 */
public class BinarySearchTree {

    /**
     * 给定一颗二叉树，判断是否是二叉搜索树
     *      leetcode 98
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(null==root)
            return true;
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        Long pre=Long.MIN_VALUE;//Integer leetcode 卡边界
        for (Integer num: list){
            if(num<pre){
                return  false;
            }
            pre=num.longValue();
        }
        return true;
    }


    //二叉搜索树中序为有序序列
    public void inOrder(TreeNode root, List<Integer> nodes){
        if(root==null)
            return ;
        inOrder(root.left,nodes);
        nodes.add(root.val);
        inOrder(root.right,nodes);
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
