import java.util.HashSet;
import java.util.Set;

/*
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/23
 */
public class JavaBean {
    public  final static Integer age = 666;
    public String s = "abc";
    private int value = 1;

    public int getValue() {
        return value;
    }

    public void setValue(int v) {
        final int temp = 3;
        this.value = temp + v;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(2);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(8);
        System.out.println(set);
    }
}
