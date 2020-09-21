package bfs;

import java.util.LinkedList;

/**
 * @author Xulingfeng
 * @description
 * @date 2020/9/4
 */
public class 遍历二叉树最短路径 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        //放入起点
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            //当前深度
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                //当前节点
                TreeNode cur = queue.getLast();
                queue.removeLast();
                //判断终点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                //将相邻节点加入队列中
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode6;
        System.out.println(new 遍历二叉树最短路径().minDepth(treeNode0));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}


