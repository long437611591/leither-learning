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
package arm.iot.sec.dependencyInject;

import arm.iot.sec.dependencyInject.service.AService;
import arm.iot.sec.dependencyInject.service.BService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
//        testSetterBasedInjection();

        testMethodInjectionMeanings();
    }

    private static void testMethodInjectionMeanings() {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext("arm.iot.sec.dependencyInject");
        BService bService = ctx.getBean(BService.class);
        bService.test(1);
        bService.test(2);
        bService.test(3);
        System.out.println("beautiful spliting ....");
        bService.test$2(1);
        bService.test$2(2);
        bService.test$2(3);
        System.out.println("beautiful spliting ....");
        bService.test$21(1);
        bService.test$21(2);
        bService.test$21(3);


    }


    private static void testSetterBasedInjection() {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext("arm.iot.sec.dependencyInject");
        AService aservice = ctx.getBean(AService.class);
        aservice.test();
    }
}
