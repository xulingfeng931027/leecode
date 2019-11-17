/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/28
 */
public class ByteCodeDemo {
    private int a=1;

    public int add() throws Exception {
        int b = 2;
        int c = a + b;
        System.out.println(c);
        Thread.sleep(1);
        return c;
    }

}

