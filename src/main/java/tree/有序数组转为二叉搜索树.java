package tree;//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
// 👍 592 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class 有序数组转为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST0(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST0(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST0(nums, start, mid - 1);
        root.right = sortedArrayToBST0(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        有序数组转为二叉搜索树 test = new 有序数组转为二叉搜索树();
        System.out.println(test.sortedArrayToBST(new int[]{1, 2, 3, 4, 5}));
    }
}

//leetcode submit region end(Prohibit modification and deletion)
