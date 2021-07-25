package com.tl.struct;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, sum, root, new ArrayList<Integer>());
        return res;
    }


    public static void dfs(List<List<Integer>> res, int sum, TreeNode treeNode, List<Integer> tree) {

        //结束
        if (null == treeNode) {
            tree.stream().reduce(Integer::sum)
                    .ifPresent(value -> {
                        if (value == sum) {
                            res.add(new ArrayList<>(tree));
                            //去掉最后一个继续递归
                            tree.remove(tree.size() - 1);
                        }
                    });
            return;
        }

        tree.add(treeNode.val);
        dfs(res, sum, treeNode.left, tree);

        dfs(res, sum, treeNode.right, tree);

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

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1] 22
        Integer [] array={5,4,8,11,null,13,4,7,2,null,null,5,1};

        TreeNode treeNode = TreeNode.generateTreeNode(array);

        pathSum(treeNode, 22);


    }


}
