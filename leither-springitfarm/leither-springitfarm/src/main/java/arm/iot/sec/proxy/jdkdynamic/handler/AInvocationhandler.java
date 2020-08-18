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
package arm.iot.sec.proxy.jdkdynamic.handler;

import arm.iot.sec.proxy.jdkdynamic.service.AService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AInvocationhandler implements InvocationHandler {

    private AService target;

    public AInvocationhandler(AService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("proxy invoke");
        if (method.getReturnType().equals(Void.TYPE)) {
            return null;
        } else {
            System.out.println("invoke: " + invoke);
            return invoke + "proxy";
        }
    }
}
