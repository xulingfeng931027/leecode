package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序
 *
 * @author Xulingfeng
 * @description
 * @date 2020/9/26
 */
public class InOrderTraverse {
    public static void main(String[] args) {
        InOrderTraverse parent = new InOrderTraverse();
        System.out.println(parent.preorderTraversal(TreeUtil.generateTree(new Integer[]{0, 1, 2, 3, 4, 5, 6})));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

