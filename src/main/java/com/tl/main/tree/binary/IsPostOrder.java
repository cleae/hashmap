package com.tl.main.tree.binary;

import java.util.Deque;
import java.util.LinkedList;

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
        return verify(postorder,0,postorder.length-1);
    }

    /**
     *     5
     *    / \
     *   2   6
     * / \
     *1   3
     * [1,3,2,6,5]
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    public boolean verify(int [] postorder, int i, int j){
        if(i>=j){//左子树是叶子节点或者没有左子树
            return true;
        }
        int m=i;
        for (int k = i; k <= j; k++) {
            if(postorder[k]>=postorder[j]){//找到当前子树的根节点
                m=k;
                break;
            }
        }
        int n=m;
        while(postorder[n]>postorder[j]){//判断右子树是否都大于根节点
            n++;
        }
        boolean left = verify(postorder, i, m - 1);//验证左子树
        boolean right= verify(postorder,m,j-1);//验证右子树
        return left &&right&&n==j;
    }

    /**
     * 迭代+单调栈
     *     5
     *    / \
     *   2   6
     * / \
     *1   3
     * [1,3,2,6,5]
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int pervElem = Integer.MAX_VALUE;
        for (int i = postorder.length - 1;i>=0;i--){
            if (postorder[i] > pervElem){
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                pervElem = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }


}
