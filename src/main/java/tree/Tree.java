package tree;

public class Tree {

    TreeNode root;

    public Tree(int[] a) {
        root = createBinaryTreeByArray(a, 1);
    }


    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            int value = array[index];
            root = new TreeNode(value);
            root.left = createBinaryTreeByArray(array, 2 * index);
            root.right = createBinaryTreeByArray(array, 2 * index + 1);
            return root;
        }
        return root;
    }


}

