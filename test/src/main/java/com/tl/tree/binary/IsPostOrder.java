package com.tl.tree.binary;

/**
 * description: IsPostOrder
 * created by lintan at 2020/12/3 11:42
 */
public class IsPostOrder {


    /**
     * 给定二叉搜索树的遍历序列，判断是否为后续遍历序列
     *      递归分治
     *          找到根节点，划分左右子树，左子树所有值都小于根节点，右子树所有值都大于根节点
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length);
    }

    /**
     *
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    public boolean verify(int [] postorder, int i, int j){
        if(i==j){
            return true;
        }
        int m=i;
        while(postorder[m]<postorder[j]){
            m++;
        }
        boolean left = verify(postorder, i, m - 1);
        boolean right= verify(postorder,m,j-1);
        return left &&right;
    }
}
