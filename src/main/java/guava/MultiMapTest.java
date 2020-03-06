package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/3/6
 */
public class MultiMapTest {
    public static void main(String[] args) {
        Multimap<String, Integer> multiMap = ArrayListMultimap.create();
        multiMap.put("a", 1);
        multiMap.put("a", 2);
        multiMap.put("a", 3);
        System.out.println(multiMap);

    }
}
