package tree;//给定一个二叉树，返回它的中序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 711 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class 二叉树中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        track(root, list);
        return list;
    }

    void track(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        track(root.right, list);
        track(root.left, list);
        list.add(root.val);

    }

    public static void main(String[] args) {
        二叉树中序遍历 test = new 二叉树中序遍历();
        System.out.println(test.inorderTraversal(TreeUtil.generateTree(new int[]{0, 1, 2, 3, 4, 5, 6})));
    }
}


//leetcode submit region end(Prohibit modification and deletion)
