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
package arm.iot.sec.aop.api;

import arm.iot.sec.aop.api.advice.DemoAfterReturnAdvice;
import arm.iot.sec.aop.api.advice.DemoAroundAdvice;
import arm.iot.sec.aop.api.advice.DemoIntroductionAdvice;
import arm.iot.sec.aop.api.advice.DemoMethodBeforeAdvice;
import arm.iot.sec.aop.api.pointcut.DemoPointCut;
import arm.iot.sec.aop.api.service.BService;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Main {

    public static void main(String[] args) {


        ProxyFactory proxyFactory = new ProxyFactory();

        // 一个Advisor代表的是一个已经跟指定切点绑定了的通知
        // 在这个例子中意味着环绕通知不会作用到toString方法上
        Advisor advisor = new DefaultPointcutAdvisor(new DemoPointCut(), new DemoAroundAdvice());

        // 添加一个绑定了指定切点的环绕通知
        proxyFactory.addAdvisor(advisor);

        // 添加一个方法执行前的通知
        proxyFactory.addAdvice(new DemoMethodBeforeAdvice());

        // 为代理类引入一个新的需要实现的接口--Runnable
        proxyFactory.addAdvice(new DemoIntroductionAdvice());

        // 设置目标类
        proxyFactory.setTarget(new BService());

        // 因为要测试代理对象自己定义的方法，所以这里启用cglib代理
        proxyFactory.setProxyTargetClass(true);

        // 创建代理对象
        Object proxy = proxyFactory.getProxy();

        // 调用代理类的toString方法，通过控制台查看代理逻辑的执行情况
        proxy.toString();

        if (proxy instanceof BService) {
            ((BService) proxy).toAop();
        }

        // 判断引入是否成功，并执行引入的逻辑
        if (proxy instanceof Runnable) {
            ((Runnable) proxy).run();
        }
    }
}
