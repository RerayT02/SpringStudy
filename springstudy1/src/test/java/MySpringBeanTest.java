import com.reray.spring.study.MySpringBean;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author pu wang
 * @date 2025/10/29 17:14
 */
public class MySpringBeanTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MySpringBeanTest.class);

    String oriProperty;

    @Before
    public void setUp() {
        oriProperty = System.getProperty("spring.profiles.active");
    }

    @Test
    public void test() {
        try {
            System.setProperty("spring.profiles.active", "prod");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
            MySpringBean beanName = (MySpringBean) context.getBean("myBeanName");
            System.out.println(beanName.getBeanName());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            finalClear(oriProperty);
        }

    }

    @Test
    public void test2() {
        try {
            System.setProperty("spring.profiles.active", "dev");
            XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
            MySpringBean beanName = (MySpringBean) xmlBeanFactory.getBean("myBeanName");
            System.out.println(beanName.getBeanName());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            finalClear(oriProperty);
        }

    }

    private void finalClear(String oriProperty) {
        if (oriProperty != null) {
            System.setProperty("spring.profiles.active", oriProperty);
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }


}
