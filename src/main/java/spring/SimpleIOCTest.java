package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/21
 */
public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-test.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
