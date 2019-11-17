/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/28
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal =
            ThreadLocal.withInitial(
                    () -> 1);

    public static void main(String[] args) {
        System.out.println(threadLocal.get());
    }
}

