package com.tl.main.tree.binary;


import java.util.ArrayList;
import java.util.List;

/**
 * 判断二叉树是否对对称
 */
public class SymmetryTree {

    /**
     *
     *                    5
     *                 /    \
     *              4        1
     *            /  \      /  \
     *          nil   1    nil  4
     *               / \       / \
     *             2   nil    2   nil
     *
     *  中序遍历的思想过不了上述用例
     */
    public boolean isSymmetric(TreeNode root) {
        if(null==root|| (root.left==null&&root.right==null))
            return true;
        List<Integer> list=new ArrayList<>();
        inorder(root,list,null);
        if(list.size()%2==0){
            return false;
        }
        int mid=list.size()/2;
        //[3,2,4,1,4,2,3]
        int left=mid;
        int right=mid;
        /*for(Integer i: list){
            System.out.print(i+ "\t");
        }
        System.out.println();
        System.out.print(mid+ "\t");*/
        for(int i=1; i<=mid; i++){
            if(list.get(left-i)!=list.get(right+i)){
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> list,TreeNode pre){
        if(null==root){
            if(pre !=null && ( (pre.left==null &&pre.right!=null) || (pre.right==null &&pre.left!=null)))
                list.add(null);
            return;
        }
        pre=root;
        inorder(root.left,list,pre);
        list.add(root.val);
        inorder(root.right,list,pre);
    }

    private static class Solution{
        public boolean isSymmetric(TreeNode root) {
            return root == null || recur(root.left, root.right);
        }
        boolean recur(TreeNode L, TreeNode R) {
            if(L == null && R == null) return true;
            if(L == null || R == null || L.val != R.val) return false;
            return recur(L.left, R.right) && recur(L.right, R.left);
        }
    }

}
