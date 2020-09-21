/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/12/16
 */

public class ClassLoadTest {

    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Son extends Father {
    public static String strSon = "HelloJVM_Son";

    static {
        System.out.println("Son静态代码块");
    }
    public Son() {
        System.out.println("Son构造函数");
    }
    {
        System.out.println("son普通代码块");
    }
}

class Father extends YeYe{
    public static String strFather = "HelloJVM_Father";

    static {
        System.out.println("Father静态代码块");
    }
    {
        System.out.println("father普通代码块");
    }

    public Father() {
        System.out.println("Father构造函数");
    }
}

class YeYe {
    static {
        System.out.println("YeYe静态代码块");
    }
}
