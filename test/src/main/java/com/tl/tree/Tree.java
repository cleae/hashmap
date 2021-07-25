package com.tl.tree;

import java.util.*;

/**
 * description: Tree
 * created by lintan at 2020/10/28 12:43
 */
public class Tree {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 中序遍历迭代方式
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        int maxsize = 100;
        TreeNode[] treeNodes = new TreeNode[maxsize];
        int top = -1;
        //左根右
        TreeNode treeNode = root;
        do {
            while (treeNode != null) {
                treeNodes[++top] = treeNode;
                treeNode = treeNode.left;
            }
            if (top == -1)
                break;
            treeNode = treeNodes[top--];
            res.add(treeNode.val);
            treeNode = treeNode.right;
        } while (treeNode != null || top != -1);
        return res;
    }

    /**
     * 后续迭代方式
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        TreeNode curr = null;
        //左右根
        while (!stack.empty()) {
            curr = stack.peek();
            //当前节点的左右节点都访问过了,或者为叶子节点
            if ((curr.left == null && curr.right == null)
                    || ((curr.left == pre || curr.right == pre) && pre != null)) {
                res.add(curr.val);
                pre = curr;
            } else {
                //有右子树
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                //有左子树
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }

        }
        return res;
    }

    /**
     * 前序
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        //根左右
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                res.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (stack.empty())
                break;
            treeNode = stack.pop();
            treeNode = treeNode.right;
        }
        return res;
    }

    /**
     * 层序
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return new ArrayList<List<Integer>>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> head = new ArrayList();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                head.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(head);
        }

        return res;
    }

    /**
     * 重构二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p>
     * <p>
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder =[3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * <p>
     *      3
     *     / \
     *    9  20
     *      /  \
     *     15   7
     *
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    /**
     * 给出层序遍历结果，构建二叉树
     *
     * @param lever [3,9,20,null,null,15,7], 2^3 -1
     * @return
     */
    public static TreeNode createTree(Integer[] lever) {
        if (lever.length == 0)
            return null;
        if(lever.length%2!=1)
            throw new IllegalArgumentException("参数错误");
        if (lever.length == 1)
            return new TreeNode(lever[0], null, null);
        TreeNode root = new TreeNode(lever[0], null, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int front=1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (front < lever.length) {
                if(lever[front]!=null&&null!=node){
                    node.left=new TreeNode(lever[front],null,null);
                    queue.offer(node.left);
                }else{
                    queue.offer(null);
                }
                front++;
                if(lever[front]!=null&&null!=node){
                    node.right=new TreeNode(lever[front],null,null);
                    queue.offer(node.right);
                }else{
                    queue.offer(null);
                }
                front++;
            }
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node15 = new TreeNode(15, null, null);

        TreeNode node20 = new TreeNode(20, node15, node7);

        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node = new TreeNode(3, node9, node20);

        levelOrder(node);

//        Integer[] lever={3,9,20,null,null,15,7};

        Integer[] lever={3,null,20,null,null,15,7};
        createTree(lever);

    }

}
