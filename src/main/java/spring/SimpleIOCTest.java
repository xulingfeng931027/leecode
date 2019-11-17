package spring;

import org.junit.Test;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/21
 */
public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("spring-test.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
