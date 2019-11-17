import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/2
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            lock.lock();
            System.out.println("线程1抢锁成功");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            lock.unlock();
            System.out.println("线程1解锁成功");
        }, "thread-1");
        Thread thread2 = new Thread(() -> {
            lock.lock();
            System.out.println("线程2抢锁成功");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("线程2解锁成功");
        }, "thread-2");
        Thread thread3 = new Thread(() -> {
            lock.lock();
            System.out.println("线程3抢锁成功");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("线程3解锁成功");
        }, "thread-3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
