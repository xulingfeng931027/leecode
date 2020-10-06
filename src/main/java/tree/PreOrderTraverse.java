package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xulingfeng
 * @description
 * @date 2020/9/26
 */
public class PreOrderTraverse {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pop();
            result.add(poll.val);
            if (poll.right != null) {
                stack.add(poll.right);
            }
            if (poll.left != null) {
                stack.add(poll.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PreOrderTraverse parent = new PreOrderTraverse();
        System.out.println(parent.preorderTraversal(TreeUtil.generateTree(new Integer[]{0, 1, 2, 3, 4, 5, 6})));
    }
}
