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
package arm.iot.sec.proxy.cglib;

import arm.iot.sec.proxy.cglib.beans.Target;
import arm.iot.sec.proxy.cglib.interceptors.InterceptorA;
import org.aopalliance.intercept.Interceptor;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
//        test01();
        testWithSpecificMethodIntercept();
    }

    private static void testWithSpecificMethodIntercept() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"code");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallbacks(new Callback[]{new InterceptorA(), NoOp.INSTANCE});
        enhancer.setInterfaces(new Class[]{Interceptor.class});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("g")){
                    return 0;
                }
                return  1;
            }
        });

        Target target = (Target) enhancer.create();
        target.g();
        target.f();
    }

    private static void test01() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./code");
        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Target.class);

        enhancer.setCallback(new InterceptorA());

        Target target = (Target) enhancer.create();

        target.f();
        target.g();
    }


}
