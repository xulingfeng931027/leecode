package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/11/10
 */
public class JdkProxy implements InvocationHandler {

    private MyInterface myInterface;

    public JdkProxy(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        JdkProxy jdkProxy = new JdkProxy(myInterface);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(myInterface.getClass().getClassLoader(), myInterface.getClass().getInterfaces(), jdkProxy);
        proxy.test();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前");
        Object result = method.invoke(myInterface, args);
        System.out.println("方法执行后");
    System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        return result;
    }
}
