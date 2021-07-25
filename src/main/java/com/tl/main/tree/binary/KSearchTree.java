package com.tl.main.tree.binary;

import com.tl.main.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * description: KSearchTree
 * created by lintan at 2020/12/3 16:00
 */
public class KSearchTree {

    /**
     * 二叉搜索树的第k大的值
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res.get(res.size()-k);
    }


    /**
     * 二叉排序树以中序遍历的方式遍历结果是有序的
     * @param root
     * @param val
     */
    public void inOrder(TreeNode root, List<Integer> val){
        if(root==null)
            return;
        inOrder(root.left,val);
        val.add(root.val);
        inOrder(root.right,val);
    }


    /**
     * 优化
     */
    class Solution {
        private int ans = 0, count = 0;
        public int kthLargest(TreeNode root, int k) {
            inOrder(root, k);
            return ans;
        }

        private void inOrder(TreeNode root, int k) {
            if (root.right != null) inOrder(root.right, k);

            if (++count == k) {
                ans = root.val;
                return;
            }

            if (root.left != null) inOrder(root.left, k);
        }
    }
}
