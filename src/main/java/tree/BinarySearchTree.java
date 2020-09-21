package tree;

/**
 * 二叉查找树
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点都大于其父节点,
 * 右子树中的每个节点都小于父节点
 *
 * @author 逼哥
 * @date 2019/10/8
 */
public class BinarySearchTree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 判断查找树是否合法
     *
     * @param root 根节点
     * @return boolean
     * @author lingfeng.xu
     * @date 2020/9/13 12:18
     */
    public boolean isValid(Node root) {
        return isValid0(root, null, null);
    }

    private boolean isValid0(Node root, Node max, Node min) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return isValid0(root.left, min, root) && isValid0(root.right, root, max);
    }

    /**
     * 寻找某个给定值的节点
     *
     * @param data
     * @return
     */
    public Node isInBST(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        }
        if (root.data < target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }
    
    /**
     * 插入节点
     *
     * @param val 待插入节点的值
     * @return
     */
    public void insert(int val) {
        Node node = new Node(val);
        Node head = root;
        while (head != null) {
            //遍历右节点
            if (head.data < val) {
                //根节点的值比val小
                if (head.right == null) {
                    head.right = node;
                    return;
                }
                head = head.right;
                //遍历左节点
            } else if (head.data > val) {
                //根节点的值比val小
                if (head.left == null) {
                    head.left = node;
                    return;
                }
                head = head.left;
            } else {
                return;
            }
        }
    }

    /**
     * 删除给定值的节点
     *
     * @return 不存在返回false
     */
    public boolean delete(int val) {
        //记录的是待删除节点的父节点
        Node note = root;
        Node toDel = null;
        while (note != null && note.data != val) {
            toDel = note;
            //遍历右节点
            if (note.data < val) {
                note = note.right;
                //遍历左节点
            } else {
                note = note.left;
            }

        }
        if (toDel == null) {
            return false;
        }
        // 删除节点是叶子节点或者仅有一个子节点
        // 待删除节点的子节点
        Node child;
        if (toDel.left != null) {
            child = toDel.left;
        } else if (toDel.right != null) {
            child = toDel.right;
        } else {
            child = null;
        }
        return true;
    }

    /**
     * 节点内部类
     */
    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

