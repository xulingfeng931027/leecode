package tree;//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化
//为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 115 👎 0


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


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> indexList = new ArrayList<>();
        serialize0(root, indexList, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexList.size(); i++) {
            if (i < indexList.size() - 1) {
                sb.append(indexList.get(i)).append(",");
            } else {
                sb.append(indexList.get(i));
            }
        }
        return sb.toString();
    }

    void serialize0(TreeNode root, List<Integer> indexList, int index) {
        if (root == null) {
            return;
        }
        indexList.add(index, root.val);
        serialize0(root.left, indexList, 2 * index + 1);
        serialize0(root.right, indexList, 2 * index + 2);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length == 0) {
            return null;
        }
        return serialize0(split, 0);
    }

    private TreeNode serialize0(String[] split, int index) {
        if (index > split.length - 1) {
            return null;
        }
        String val = split[index];
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = serialize0(split, 2 * index + 1);
        root.right = serialize0(split, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String treeStr = codec.serialize(TreeUtil.generateTree(new Integer[]{1, null, 2, 3, null}));
        System.out.println(treeStr);
        System.out.println(codec.deserialize(treeStr));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
