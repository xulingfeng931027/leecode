package spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.annotation.PostConstruct;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/10/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car implements BeanFactoryPostProcessor {
    private String name;
    private int length;
    private int age;
    private Person person;

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("容器加载完成");
    }

    @PostConstruct
    public void test() {
        System.out.println("容器回调");
    }
}
