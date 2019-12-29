import java.util.ArrayList;
import java.util.List;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/28
 */
public class OOMTest {
    //-Xms20m -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        for (; ; ) {
            list.add("aaaa");
        }
    }

}

