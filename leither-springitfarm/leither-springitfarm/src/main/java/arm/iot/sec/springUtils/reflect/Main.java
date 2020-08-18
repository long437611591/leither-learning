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
package arm.iot.sec.springUtils.reflect;

import arm.iot.sec.proxy.cglib.interceptors.InterceptorA;
import arm.iot.sec.springUtils.reflect.bean.BeanA;
import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.ConstructorInvocation;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.concurrent.locks.LockSupport;


public class Main {


    public static void main(String[] args) {
//        test01();
//        testField();
//        testAnnotationElementUtils();

        testStaticBeanMethod();
    }

    private static void testStaticBeanMethod() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("arm.iot.sec.springUtils.reflect.bean");
        applicationContext.refresh();
        LockSupport.park();
//        applicationContext
//                .start();

    }


    private static void testAnnotationElementUtils() {

        try {
            Bean getInterceptor = AnnotatedElementUtils.findMergedAnnotation(BeanA.class.getMethod("getInterceptor", null), Bean.class);
//            Bean getInterceptor2 = AnnotatedElementUtils.findMergedAnnotation(BeanA.class.getMethod("getInterceptor", String.class), Bean.class);
            AnnotationAttributes mergedAnnotationAttributes = AnnotatedElementUtils.findMergedAnnotationAttributes(BeanA.class.getMethod("getInterceptor", null), Bean.class, false, false);

        }catch (NoSuchMethodException e){
        }catch (SecurityException e){

        }
    }

    private static void testField() {


        ConstructorInterceptor constructorInterceptor = new ConstructorInterceptor() {
            @Override
            public Object construct(ConstructorInvocation invocation) throws Throwable {
                return "";
            }

        };
        BeanA beanA = new BeanA();

        Field interceptorField = ReflectionUtils.findField(beanA.getClass(), "interceptor");
        Field beanNameField = ReflectionUtils.findField(BeanA.class, "beanName");
        System.out.println(interceptorField);
        try {
            interceptorField.setAccessible(true);
            beanNameField.setAccessible(true);
            interceptorField.set(beanA, constructorInterceptor);
            beanNameField.set(beanA,"hahaha");
        } catch (Exception e) {

        }
        System.out.println(beanA);
    }

    private static void test01() {
//        InterceptorA interceptorA = new InterceptorA();
        System.out.println("is beand annotated " + ": " + AnnotatedElementUtils.hasAnnotation(InterceptorA.class.getMethods()[0], Bean.class));


    }

}
