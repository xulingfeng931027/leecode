package tree;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索
// 👍 479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @author Xulingfeng
 * @description 平衡二叉树的解法  递归计算树的高度
 * @date 2020/9/18
 */
public class BalancedTree {

    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        computeHeight(root);
        return isBalance;
    }

    private int computeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = computeHeight(root.left);
        int rightHeight = computeHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalance = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(new int[]{0, 2, 4, 5, 6, 1});
        System.out.println(new BalancedTree().computeHeight(tree.root));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

