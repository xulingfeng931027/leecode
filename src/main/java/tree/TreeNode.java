package tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}