package 回溯;//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。
//
//
//
// 例如，上面的二进制手表读取 “3:25”。
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
//
//
//
// 示例：
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"]
//
//
//
// 提示：
//
//
// 输出的顺序没有要求。
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
//
// Related Topics 位运算 回溯算法
// 👍 162 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class 二进制手表 {

    List<String> result = new ArrayList<>();
    int num;

    public List<String> readBinaryWatch(int num) {
        if (num == 0) {
            result.add("0:00");
            return result;
        }
        this.num = num;
        Map<Integer, Integer> map = new HashMap<>();
        backTrack(map, 0);
        return result;
    }

    void backTrack(Map<Integer, Integer> map, int begin) {
        //退出条件 如果当前亮灯数量等于最大数量了
        if (map.size() == num) {
            String time = calculate(map);
            if (time != null) {
                result.add(time);
            }
            return;
        }
        for (int i = begin; i < 10; i++) {
            //剪枝
            String time = calculate(map);
            if (time == null) {
                continue;
            }
            //做选择
            map.put(i, 1);
            backTrack(map, i + 1);
            //撤销选择
            map.remove(i);
        }
    }

    /**
     * 根据亮灯滴位置计算时间
     */
    private String calculate(Map<Integer, Integer> map) {
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < 10; i++) {
            if (map.get(i) != null) {
                if (i <= 3) {
                    hour += 1 << (3 - i);
                    if (hour > 11) {
                        return null;
                    }
                }
                if (i >= 4) {
                    minute += 1 << (9 - i);
                    if (minute >= 60) {
                        return null;
                    }
                }
            }
        }
        if (minute < 10) {
            return "" + hour + ":" + "0" + minute;
        } else {
            return "" + hour + ":" + minute;
        }
    }

    public static void main(String[] args) {
        二进制手表 test = new 二进制手表();
        List<String> x = test.readBinaryWatch(2);
        System.out.println(x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
