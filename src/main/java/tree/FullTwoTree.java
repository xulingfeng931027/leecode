package tree;

import java.util.Arrays;

/**
 * 大顶堆实现优先级队列
 *
 * @author Xulingfeng
 * @description
 * @date 2020/9/5
 */
public class FullTwoTree {

    private int[] data;
    private int deep;

    public FullTwoTree(int n) {
        //第0个索引不用
        data = new int[n + 1];
    }


    private void swap(int n, int m) {
        int temp = data[n];
        data[n] = data[m];
        data[m] = temp;
    }

    /**
     * 上浮节点
     */
    private void up(int n) {
        //大于父节点 将此节点上浮
        while (n > 1 && data[n] > data[n / 2]) {
            swap(n, n / 2);
            n = n / 2;
        }
    }

    /**
     * 下沉节点
     */
    private void down(int n) {
        //大于父节点 将此节点上浮
        while (n <= deep) {
            //假设左节点
            int index = 2 * n;
            //如果右节点存在比较一下
            if (2 * n + 1 <= deep && data[index] < data[index + 1]) {
                index++;
            }
            swap(n, index);
            n = index;
        }
    }

    /**
     * 移除
     *
     * @return
     */
    public int pollMax() {
        //堆顶元素最大
        int max = data[1];
        swap(1, deep);
        data[deep] = 0;
        deep--;
        //让data[1]下沉到正确的位置
        down(1);
        return max;
    }

    public void insert(int num) {
        deep++;
        //插到末尾
        data[deep] = num;
        up(deep);
    }

    public static void main(String[] args) {
        FullTwoTree tree = new FullTwoTree(10);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(5);
        System.out.println(tree);
    }

    @Override
    public String toString() {
        return "FullTwoTree{" +
                "data=" + Arrays.toString(data) +
                ", deep=" + deep +
                '}';
    }
}
