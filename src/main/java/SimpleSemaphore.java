import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 简单信号量工具
 *
 * @author 逼哥
 * @date 2019/10/2
 */
public class SimpleSemaphore {

    private SimpleSync simpleSync;

    public SimpleSemaphore(int lockNum) {
        simpleSync = new SimpleSync(lockNum);
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleSemaphore simpleSemaphore = new SimpleSemaphore(10);
        CountDownLatch latch = new CountDownLatch(4);
        Thread thread1 = new Thread(() -> {
            simpleSemaphore.acquireLock(8);
            System.out.println("线程1抢锁成功,信号池还剩:" + simpleSemaphore.getLockNum());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            simpleSemaphore.release(5);
            System.out.println("线程1释放锁成功,信号池还剩:" + simpleSemaphore.getLockNum());
            latch.countDown();
        },"thread-1");
        Thread thread2 = new Thread(() -> {
            simpleSemaphore.acquireLock(5);
            System.out.println("线程2抢锁成功,,信号池还剩:" + simpleSemaphore.getLockNum());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            simpleSemaphore.release(5);
            System.out.println("线程2释放锁成功,信号池还剩:" + simpleSemaphore.getLockNum());
            latch.countDown();

        },"thread-2");
        Thread thread3 = new Thread(() -> {
            simpleSemaphore.acquireLock(3);
            System.out.println("线程3抢锁成功,信号池还剩:" + simpleSemaphore.getLockNum());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();

        },"thread-3");
        //由于正好还剩2个锁,此时线程4一定能优先拿到资源
        Thread thread4 = new Thread(() -> {
            simpleSemaphore.acquireLock(2);
            System.out.println("线程4抢锁成功,信号池还剩:" + simpleSemaphore.getLockNum());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();

        },"thread-4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    /**
     * 获取当前还剩余的锁
     *
     * @return
     */
    public int getLockNum() {
        return simpleSync.getLockNum();
    }

    public void acquireLock(int num) {
        simpleSync.acquireShared(num);
    }

    public void release(int num) {
        simpleSync.releaseShared(num);
    }

    private static class SimpleSync extends AbstractQueuedSynchronizer {
        /**
         * 允许最大的信号量
         */
        private int lockNum;

        public SimpleSync(int lockNum) {
            setState(lockNum);
        }

        /**
         * 获取当前剩余的锁
         *
         * @return
         */
        public int getLockNum() {
            return getState();
        }

        @Override protected int tryAcquireShared(int lockNum) {
            for (; ; ) {
                int available = getState();
                int remaining = available - lockNum;
                if (remaining < 0 || compareAndSetState(available, remaining)) {
                    return remaining;
                }
            }
        }

        @Override
        protected final boolean tryReleaseShared(int lockNum) {
            for (; ; ) {
                int current = getState();
                int next = current + lockNum;
                if (compareAndSetState(current, next)) {
                    return true;
                }
            }
        }
    }
}
