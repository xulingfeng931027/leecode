package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/3/6
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a", 1);
        biMap.put("b", 2);
        biMap.put("c", 3);
        System.out.println(biMap.inverse().get(2));
    }
}
