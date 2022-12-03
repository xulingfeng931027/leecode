package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 养鸡笼 {
    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> test() {
        backTrack(new ArrayList<>(), 1, 0);
        return result;
    }
    public void backTrack(List<Integer> list, int start, int sum) {
        if (list.size() == 5 && sum == 20) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 10; i++) {
            list.add(i);
            sum += i;
            backTrack(list, i + 1, sum);
            sum -= i;
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        养鸡笼 养鸡笼 = new 养鸡笼();
        List<List<Integer>> test1 = 养鸡笼.test();
        System.out.println(test1);
    }
}
