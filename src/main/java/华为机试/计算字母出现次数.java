package 华为机试;

import java.util.Scanner;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date ${DATE}.${TIME}
 */
public class 计算字母出现次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            String key = scanner.nextLine();
            int result = 0;
            char[] chars = word.toCharArray();
            for (Character c : chars) {
                if (key.equalsIgnoreCase(c.toString())) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
