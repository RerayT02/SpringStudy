import com.reray.spring.study.MySpringBean;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author pu wang
 * @date 2025/10/29 17:14
 */
public class MySpringBeanTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MySpringBean beanName = (MySpringBean) context.getBean("myBeanName");
        System.out.println(beanName.getBeanName());
    }

    @Test
    public void test2() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
        MySpringBean beanName = (MySpringBean) xmlBeanFactory.getBean("myBeanName");
        System.out.println(beanName.getBeanName());
    }


}
