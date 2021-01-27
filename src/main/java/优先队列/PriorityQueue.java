package 优先队列;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2020/11/30
 */
public class PriorityQueue {
    private List<Integer> datas;


    public PriorityQueue(int size) {
        datas = new ArrayQueue<>(size);
    }

    public int size() {
        return datas.size();
    }

    public Integer delMax() {
        if (size() == 0) {
            return 0;
        }
        //交换根节点和最后一个节点
        Integer max = datas.get(1);
        swap(1, size() - 1);
        datas.remove(size() - 1);
        down(1);
        return max;
    }

    /**
     * 将指定位置的元素下沉
     *
     * @param i
     */
    private void down(int i) {
        while (2 * i <= size() - 1) {
            int j = 2 * i;
            if (j + 1 < size() && datas.get(j + 1) > datas.get(j)) {
                j++;
            }
            if (datas.get(i) > datas.get(j)) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    public void insert(Integer data) {
        datas.add(data);
        up(size() - 1);
    }

    private void up(int i) {
        while (i > 1 && datas.get(i / 2) < datas.get(i)) {
            swap(i / 2, i);
            i /= 2;
        }
    }

    private void swap(int l, int r) {
        Integer temp = datas.get(l);
        datas.add(l, datas.get(r));
        datas.add(r, temp);
    }

}
