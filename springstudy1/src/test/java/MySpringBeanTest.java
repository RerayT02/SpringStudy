import com.reray.spring.study.MySpringBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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




}
