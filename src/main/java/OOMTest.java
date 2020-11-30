/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/28
 */
public class OOMTest {

    public void test(Human human) {
        System.out.println("human");
    }

    public void test(Man man) {
        System.out.println("man");
    }

    public static void main(String[] args) {
        OOMTest oomTest = new OOMTest();
        Human human = new Man();
        oomTest.test(human);
    }

}

class Human {

}

class Man extends Human {

}

