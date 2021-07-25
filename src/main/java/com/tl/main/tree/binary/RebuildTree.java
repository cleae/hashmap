package com.tl.main.tree.binary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 重构二叉树
 *                  给定二叉树的前序，中序遍历顺序，构建一颗二叉树
 * created by lintan at 2020/11/30 13:59
 */
public class RebuildTree {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder =[3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, n), Arrays.copyOfRange(inorder, rootIndex + 1, n));

        return root;
    }


    public static void main(String[] args) {
        int pre[] ={3,9,20,15,7};
        int order[] ={9,3,15,20,7};
        buildTree(pre,order);

    }
}
