package queue;// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.List;

public class BaseQueue {
  // 用List存储数据
  private List<Integer> data;
  // 记录起始位置的索引
  private int pStart;

  public BaseQueue() {
    data = new ArrayList<Integer>();
    pStart = 0;
  }

  public static void main(String[] args) {
    BaseQueue q = new BaseQueue();
    q.enQueue(5);
    q.enQueue(3);
    if (q.isEmpty() == false) {
      System.out.println(q.Front());
    }
    q.deQueue();
    if (q.isEmpty() == false) {
      System.out.println(q.Front());
    }
    q.deQueue();
    if (q.isEmpty() == false) {
      System.out.println(q.Front());
    }
  }

    /** Insert an element into the queue. Return true if the operation is successful. */
  public boolean enQueue(int x) {
    data.add(x);
    return true;
  }

  /** Delete an element from the queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (isEmpty() == true) {
      return false;
    }
    pStart++;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    return data.get(pStart);
  }

  /** Checks whether the queue is empty or not. */
  public boolean isEmpty() {
    return pStart >= data.size();
  }
}
