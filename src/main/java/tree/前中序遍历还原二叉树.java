package tree;//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 683 👎 0


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
public class 前中序遍历还原二叉树 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree0(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTree0(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //根节点的值 就是前序遍历的第一个索引
        int rootVal = preorder[preStart];
        //找到在中序遍历的根节点位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = buildTree0(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
        root.right = buildTree0(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
