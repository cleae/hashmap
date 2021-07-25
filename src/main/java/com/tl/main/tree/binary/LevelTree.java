package com.tl.main.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: LevelTree
 * created by lintan at 2020/12/3 10:00
 */
public class LevelTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>(0);
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.offer(p);
        boolean falg = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> head = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (falg)
                    head.addFirst(node.val);
                 else
                    head.addLast(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(head);
            falg = !falg;
        }

        return res;
    }
}
