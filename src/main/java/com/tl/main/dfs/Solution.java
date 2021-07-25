package com.tl.main.dfs;


import com.alibaba.fastjson.JSON;
import com.tl.main.Test;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22
 *
 *
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 *    [[5,4,11,2],[5,8,4,5]]
 */
public class Solution {


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, sum, root, new ArrayList<Integer>());
        return res;
    }


    public static void dfs(List<List<Integer>> res, int sum, TreeNode treeNode, List<Integer> tree) {
        if( null== treeNode)
            return;
        //结束
        if (null == treeNode.left && null == treeNode.right) {
            tree.add(treeNode.val);
            tree.stream().reduce(Integer::sum)
                    .ifPresent(value -> {
                        if (value == sum) {
                            res.add(new ArrayList<>(tree));
                        }
                        //去掉最后一个继续递归
                        tree.remove(tree.size() - 1);
                    });
            return;
        }

        tree.add(treeNode.val);
        dfs(res, sum, treeNode.left, tree);
        dfs(res, sum, treeNode.right, tree);
        //去掉最后一个继续递归
        tree.remove(tree.size() - 1);
    }


    static class   TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }

        TreeNode() {

        }


        public static TreeNode generateTreeNode(Integer[] array) {
            int length = array.length;
            TreeNode root = new TreeNode();
            TreeNode temp = root;

            int index = 0; //query
            temp.val = array[index++];
            TreeNode [] trees=new TreeNode[array.length-1];
            int front=-1,real=-1;
            while (length >= 2) {
                temp.left = array[index++]==null? null:new TreeNode(array[index], null, null);
                temp.right = array[index++]==null? null:new TreeNode(array[index], null, null);
                if(temp.left!=null)
                    trees[++real]=temp.left;
                if(temp.right!=null)
                    trees[++real]=temp.right;
                length -= 2;
                temp= trees[++front];
            }
            if(length==1)
                temp.left = array[index]==null? null:new TreeNode(array[index], null, null);
            return root;
        }


    }


    /**
     *  *
     *  *                5
     *  *              / \
     *  *             4   8
     *  *            /   / \
     *  *           11  13  4
     *  *          /  \    / \
     *  *         7    2  5   1
     * @param args
     */
    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1] 22
//        Integer [] array={5,4,8,11,null,13,4,7,2,null,null,5,1};
//
//        TreeNode treeNode = TreeNode.generateTreeNode(array);
//
//        pathSum(treeNode, 22);
        TreeNode leaf7=new TreeNode(7,null,null);
        TreeNode leaf2=new TreeNode(2,null,null);
        TreeNode leaf5=new TreeNode(5,null,null);
        TreeNode leaf1=new TreeNode(1,null,null);
        TreeNode leaf13=new TreeNode(13,null,null);

        TreeNode root11=new TreeNode(11,leaf7,leaf2);
        TreeNode root4=new TreeNode(4,leaf5,leaf1);


        TreeNode root44=new TreeNode(4,root11,null);
        TreeNode root8=new TreeNode(8,leaf13,root4);


        TreeNode root =new TreeNode(5,root44, root8);

        List<List<Integer>> lists = pathSum(root, 22);


        System.out.println(lists.size());

        System.out.println(JSON.toJSONString(lists));

    }
}
