package 回溯;//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 430 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return backTrack(root, 0, sum);
    }

    boolean backTrack(TreeNode root, int temp, int sum) {

        if (root.left != null) {
            temp += root.left.val;
            backTrack(root.left, temp, sum);
            temp -= root.left.val;
        }
        if (root.right != null) {
            temp += root.right.val;
            backTrack(root.right, temp, sum);
            temp -= root.right.val;
        }
        if (root.left == null && root.right == null) {
            return temp == sum;
        }
        return true;
    }

    public static void main(String[] args) {
        路径总和 test = new 路径总和();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
