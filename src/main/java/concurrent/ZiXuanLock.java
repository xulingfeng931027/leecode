package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS自旋锁
 *
 * @author 逼哥
 * @date 2019/11/15
 */
public class ZiXuanLock {

    private AtomicReference<Thread> cas = new AtomicReference<>();
   //线程安全
    private  int count;

    public void lock() {
        Thread thread = Thread.currentThread();
        if (thread == cas.get()) {
            count++;
            return;
        }
        while (!cas.compareAndSet(null, thread)) {
           //抢不到锁 自旋
        }
    }

    public void unlock() {
        Thread cur = Thread.currentThread();
        if (cur == cas.get()) {
            // 如果大于0，表示当前线程多次获取了该锁，释放锁通过count减一来模拟
            if (count > 0) {
                count--;
            } else {// 如果count==0，可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的了。
                cas.compareAndSet(cur, null);
            }
        }
    }

}
