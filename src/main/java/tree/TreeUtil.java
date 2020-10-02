package tree;

public class TreeUtil {


    public static TreeNode generateTree(int[] a) {
        return generateTree0(a, 1);
    }

    private static TreeNode generateTree0(int[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            int value = array[index];
            root = new TreeNode(value);
            root.left = generateTree0(array, 2 * index);
            root.right = generateTree0(array, 2 * index + 1);
            return root;
        }
        return root;
    }


}

