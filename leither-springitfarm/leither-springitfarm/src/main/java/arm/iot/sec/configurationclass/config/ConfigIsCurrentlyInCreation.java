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
package arm.iot.sec.configurationclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/***
 * @see {B}
 *
 * if (alreadyInCreation) {
 *    beanFactory.setCurrentlyInCreation(beanName, false);
 * }
 */
/**
 * 上面这种配置，在启动的时候就会进入到if条件中，
 * 在创建a的时候发现需要注入b，那么Spring此时就会去创建b，
 * b在创建的过程中又调用了a方法，此时a方法在执行时又被拦截了，
 * 然后就会进入到if判断中去。对Spring有一定了解的同学应该能感觉到，
 * 这个其实跟循环依赖的原理是一样的。关于循环依赖，
 * 在后面我单独写一篇文章进行说明。
 */
public class ConfigIsCurrentlyInCreation {
    @Bean
    public A a() {
        return new A();
    }
    @Bean
    public B b() {
        this.a();
        return new B();
    }
}

class A {
    B b;
    @Autowired
    public void setB(B b) {
        this.b = b;
    }
}

class B {
}
