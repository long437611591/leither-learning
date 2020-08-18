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
import org.springframework.stereotype.Component;

@Component
public class AService {

//    @Autowired
    private LuBanService luBanService1;
    private LuBanService luBanService2;
    private LuBanService luBanService3;

//    @Autowired //(required = false) //如果在此处也行指定构造函数
    public AService() {
        System.out.println("Aservice is now creating no args");
    }

    public void test() {
        System.out.println(String.format(this.luBanService1 + "-- LUbban002: " + this.luBanService2 + "--Luban 03: "+this.luBanService3));
    }


    @Autowired // (required = false)  如果两个构造器  优先选择符合要求的构造器  符合要求的意思指的是 参数被spring 管理着
    public AService(LuBanService luBanService) {
        System.out.println("is now injecting using the constructor based");
        this.luBanService2 = luBanService;
        this.luBanService3 = luBanService;
    }

    @Autowired
    public void setLuBanService(LuBanService luBanService) {
        System.out.println("is now injecting using the setting based");
        this.luBanService1 = luBanService;
        this.luBanService3 = null;   //构造器注入是在实例化对象的阶段进行属性注入的  但是在真正的属性注入阶段又会被进行属性覆盖
    }

}
