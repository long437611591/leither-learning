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
package arm.iot.sec.dependencyInject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BService {

    @Autowired
    private MethodInjectionLuBanService methodInjectionLuBanService;

    public void test(int a) {
        methodInjectionLuBanService.addAndPrint(a);
    }

    //注入上下位
    @Autowired
    private ApplicationContext ctx;

    public void test$2(int a) {
        MethodInjectionLuBanService$2 bean = ctx.getBean(MethodInjectionLuBanService$2.class);
        bean.addAndPrint(a);
    }

    /***
     * lookup 的方式
      * @param a
     */
    public void test$21(int a) {
        MethodInjectionLuBanService$2 luBanService$2 = lookUp();

        luBanService$2.addAndPrint(a);
    }

    @Lookup
    public MethodInjectionLuBanService$2 lookUp(){
        return  null;
    }

}
