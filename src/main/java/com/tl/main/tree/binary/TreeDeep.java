package com.tl.main.tree.binary;


import java.util.LinkedList;
import java.util.Queue;

/**
 * description: 二叉树的深度
 *                  递归
 *                  层序遍历
 * created by lintan at 2020/11/30 13:40
 */
public class TreeDeep {


    /**
     * 递归
     * @param root
     * @return
     */
    static public int maxDepth(TreeNode root) {
        if(null==root){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }


    /**
     * 层序遍历的方式实现
     * @param root
     * @return
     */
    static public int maxDepth2(TreeNode root) {
        if(null==root){
            return 0;
        }
        int deep=0;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            deep++;
        }
        return deep;
    }

}
