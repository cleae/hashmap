package com.tl.main.tree.binary;


/**
 * 合并二叉树
 *      leetcode 617
 */
public class mergeTree {


    /**
     * 合并二叉树
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(null==t1)
            return t2;
        else if(t2==null)
            return t1;
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }
}
