package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/27
 */
public class CompletableFutureTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //描述两个任务间的串行关系
        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> "HelloWorld")
                        .thenApply(s -> s + "qq")
                        .thenApply(String::toUpperCase);
        System.out.println(f1.join());

        // 异常处理
        CompletableFuture<Integer> f2 =
                CompletableFuture.supplyAsync(() -> 6)
                        .thenApply(s -> s / 0)
                        .exceptionally((e -> 0));

        System.out.println(f2.get());
    }

}

