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
package arm.iot.sec.beandefinition;

import arm.iot.sec.beandefinition.beans.SomeBeanMethodBean;
import arm.iot.sec.beandefinition.beans.SomeConfigBean;
import arm.iot.sec.beandefinition.beans.SomeFactoryBean;
import arm.iot.sec.beandefinition.beans.SomeFactroyMethod;
import arm.iot.sec.beandefinition.service.AService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

//        testClassPathAPPCtx();

//        testAnnotationConfig();

//        testBeanMethod();

        testStaticFactroyMethodBean();
    }

    private static void testStaticFactroyMethodBean() {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(SomeFactroyMethod.class);
        System.out.println(ctx.getBean("service"));
    }


    private static void testBeanMethod() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SomeBeanMethodBean.class);
        System.out.println(ctx.getBean(SomeBeanMethodBean.class));
        System.out.println(ctx.getBean(SomeBeanMethodBean.ABean.class));

    }


    private static void testAnnotationConfig() {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(SomeConfigBean.class);

        System.out.println(ctx.getBean(SomeConfigBean.class));

    }

    private static void testClassPathAPPCtx() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerBean("service", AService.class, AService::new);
        ctx.refresh();
        System.out.println(ctx.getBean("service"));

    }
}
