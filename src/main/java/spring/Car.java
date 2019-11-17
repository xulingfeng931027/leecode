package spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String name;
    private int length;
    private int age;
}
