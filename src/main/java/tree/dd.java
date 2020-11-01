package tree;//二叉搜索树中的两个节点被错误地交换。
//
// 请在不改变其结构的情况下，恢复这棵树。
//
// 示例 1:
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
//
//
// 示例 2:
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
//
// 进阶:
//
//
// 使用 O(n) 空间复杂度的解法很容易实现。
// 你能想出一个只使用常数空间的解决方案吗？
//
// Related Topics 树 深度优先搜索
// 👍 355 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private TreeNode error1;
    private TreeNode error2;
    private TreeNode pre;
    private int count;



    public void recoverTree(TreeNode root) {
        traverse(root);
        exchange(error1, error2);
    }

    private void traverse(TreeNode root) {
        if (root == null || root.val == null) {
            return;
        }
        traverse(root.left);
        if (pre != null && root.val < pre.val) {
            error2 = root;
            if (error1 == null) {
                error1 = pre;
            } else {
                return;
            }
        }
        pre = root;
        traverse(root.right);
    }

    private void exchange(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
    }


}

//leetcode submit region end(Prohibit modification and deletion)
