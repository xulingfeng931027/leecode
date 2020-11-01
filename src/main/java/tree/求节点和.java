package tree;//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 210 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import org.junit.Test;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class 求节点和 {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        backTrack(new StringBuilder(), root);
        return result;
    }

    void backTrack(StringBuilder temp, TreeNode root) {
        if (root.left == null && root.right == null) {
            //叶子节点
            temp.append(root.val);
            result += Integer.parseInt(temp.toString());
            temp.deleteCharAt(temp.length() - 1);
        }

        if (root.left != null) {
            temp.append(root.val);
            backTrack(temp, root.left);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (root.right != null) {
            temp.append(root.val);
            backTrack(temp, root.right);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeUtil.generateTree(new Integer[]{1, 2, 3});
        System.out.println(sumNumbers(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
