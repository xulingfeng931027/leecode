package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/11/11
 */
public class WaitNotifyTest {

    //锁对象
    private final static Object object = new Object();

    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService producerPool = Executors.newFixedThreadPool(1);
        ExecutorService consumerPool = Executors.newFixedThreadPool(2);
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        for (int i = 0; i < 100; i++) {
            producerPool.execute(producer);
        }
        for (int i = 0; i < 100; i++) {
            consumerPool.execute(consumer);
        }
    }

    /**
     * 生产者线程
     */
    private static class Producer implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("进入生产者线程");
                System.out.println("当前剩余数量" + count.get());
                //睡2s假装在生产
                try {
                    Thread.sleep(2000);
                    count.incrementAndGet();
                    //通知消费者消费
                    object.notifyAll();
                    System.out.println("退出生产者线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 生产者线程
     */
    private static class Consumer implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("进入消费者线程");

                while (count.get() <= 0) {
                    //不满足条件等待
                    System.out.println("不满足条件等待");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("开始消费");
                try {
                    Thread.sleep(1000);
                    count.decrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费完毕,还剩余" + count.get());
            }
        }
    }
}
