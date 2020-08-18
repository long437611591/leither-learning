/*******************************************************************************
 * Copyright (C), 2018-2018, Arm Technology (China) Co., Ltd.
 * All rights reserved
 *
 * The content of this file or document is CONFIDENTIAL and PROPRIETARY
 * to Arm Technology (China) Co., Ltd. It is subject to the terms of a
 * License Agreement between Licensee and Arm Technology (China) Co., Ltd
 * restricting among other things, the use, reproduction, distribution
 * and transfer.  Each of the embodiments, including this information and,,
 * any derivative work shall retain this copyright notice.
 ******************************************************************************/
package arm.iot.sec.springUtils.reflect.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class StaticBeanMethod {


    @Autowired
    private OtherInnerBean otherInnerBean;

    @Bean
    public  OtherInnerBean getOtherInnerBean(){
        return  new OtherInnerBean();
    }

    @Bean(name = "getSomeBeanInStaticBeanMethod")
    public SomeInnerBean getSomeBean() {

        if (otherInnerBean != null) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println("gogogoogogog autowird..................");
            System.out.println("gogogoogogog autowird..................");
        }
        return new SomeInnerBean();

    };

//    @Bean
//    public static MyInnerBeanPostProcessor getpro1(){
//        return  new MyInnerBeanPostProcessor();
//    }
       //if you want to add a beanMethod in this beanMethod the some lifecycle issues will occur @autowired @resource will not work
//        @Bean
//        public MyInnerBeanPostProcessor getpro2() {
//            return new MyInnerBeanPostProcessor();
//        }

    public static class SomeInnerBean {}
    public static class OtherInnerBean {

    }
    public static class MyInnerBeanPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {


        public MyInnerBeanPostProcessor() {
            System.out.println("MyInnerBeanPostProcessor........................");
        }

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return null;
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        }
    }
}


