package tree;

public class TreeUtil {


//    public static TreeNode generateTree(int[] a) {
//        return generateTree0(a, 0);
//    }

    public static TreeNode generateTree(Integer[] a) {
        return generateTree0(a, 0);
    }

    private static TreeNode generateTree0(Integer[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            Integer value = array[index];
            root = new TreeNode(value);
            root.left = generateTree0(array, 2 * index + 1);
            root.right = generateTree0(array, 2 * index + 2);
            return root;
        }
        return root;
    }


}

