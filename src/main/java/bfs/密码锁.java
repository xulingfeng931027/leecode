package bfs;

import java.util.*;

/**
 * @author Xulingfeng
 * @description
 * @date 2020/9/4
 */
public class 密码锁 {

    private String plusOne(String pass, int i) {
        char[] chars = pass.toCharArray();
        char num = chars[i];
        if (num == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    private String minusOne(String pass, int i) {
        char[] chars = pass.toCharArray();
        char num = chars[i];
        if (num == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

    public int bfs(String[] deads, String target) {
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        //记录路径 防止重复路径
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        //记录死亡集合,命中则跳过
        Set<String> deadSet = new HashSet<>(Arrays.asList(deads));

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                String cur = q.poll();
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    System.out.println("到达终点,路径数" + step);
                    return step;
                }
                //将相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            //打印初每次的路径
            System.out.println(q.peek());
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new 密码锁().bfs(new String[]{"6765,6767,6768,8888,1234"}, "8888"));
    }

}
