package tree;

/**
 * 堆结构
 *
 * @author 逼哥
 * @date 2019/10/10
 */
public class Heap {
    static Heap f;
    final int x;
    int y;

    public Heap() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new Heap();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;  // guaranteed to see 3
            int j = f.y;
            System.out.println(j);// could see 0
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                Heap.writer();
                Heap.reader();
            }).start();
        }

    }
}
