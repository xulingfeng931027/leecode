package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/3/6
 */
public class GuavaTest {

    private static final Joiner joiner = Joiner.on(",").skipNulls();
    private static final Splitter splitter = Splitter.on(",").trimResults();

    public static void main(String[] args) {
        String s = " 1,2 ,3";
        System.out.println(splitter.split(s));
        System.out.println(joiner.join(Lists.newArrayList(1, 2, null, 3, null)));
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        ImmutableList<Integer> immutableList = ImmutableList.copyOf(list);
        System.out.println(immutableList);
        list.add(4);
        System.out.println(immutableList);

    }
}
