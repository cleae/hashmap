package com.tl.main.tree;

/**
 * description: TreeParent
 * created by lintan at 2020/10/28 13:02
 */
public class TreeParent {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 返回p q 节点最近的父节点
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //思路：后序遍历
        // 结束条件：当p,q 都遍历完之后结束遍历，返回root
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左节点是最近父节点
        if(left == null) return right;
        //右节点是最近父节点
        if(right == null) return left;
        //左右节点的最近父节点
        return root;
    }


}
