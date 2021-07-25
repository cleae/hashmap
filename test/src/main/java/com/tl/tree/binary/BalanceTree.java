package com.tl.tree.binary;

/**
 * description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *          给定一棵树，判断他是否为AV树
 * created by lintan at 2020/11/30 13:56
 */
public class BalanceTree {

    /**
     * 判断是否为平衡树
     *      输入：[1,2,2,3,null,null,3,4,null,null,4]
     *      输出：
     *      true
     *      预期：
     *      false
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(null==root){
            return true ;
        }
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return false;
    }

    //二叉树深度
    static public int maxDepth(TreeNode root) {
        if(null==root){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}
