package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/27
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(
                        () -> {
                            try {
                                System.out.println("T1洗水壶");
                                TimeUnit.MICROSECONDS.sleep(1);
                                System.out.println("T1烧开水");
                                TimeUnit.MICROSECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                System.out.println("T2:洗茶壶...");
                                TimeUnit.MICROSECONDS.sleep(1);
                                System.out.println("T2:洗茶杯...");
                                TimeUnit.MICROSECONDS.sleep(1);
                                System.out.println("T2:拿茶叶...");
                                TimeUnit.MICROSECONDS.sleep(1);
                                return "⻰井";
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return "";
                            }
                        });
        CompletableFuture<String> f3 = f1.thenCombine(f2, (none, tf) -> {
            System.out.println("T3:拿到茶叶:" + tf);
            System.out.println("T3:泡茶");
            return "上茶:" + tf;
        });

        System.out.println(f3.join());
    }
}

