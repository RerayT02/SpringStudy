package com.reray.spring.study;

/**
 * @author pu wang
 * @date 2025/11/6 15:31
 */
public class MySpringBeanDev implements MySpringBean {

    @Override
    public String getBeanName() {
        return "beanName-dev";
    }
}
