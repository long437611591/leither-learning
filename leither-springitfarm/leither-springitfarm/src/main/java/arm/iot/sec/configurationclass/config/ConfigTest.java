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


import arm.iot.sec.proxy.jdkdynamic.service.AService;
import arm.iot.sec.proxy.jdkdynamic.service.impl.AServiceImpl;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@EnableAspectJAutoProxy
public class ConfigTest {
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    /**
     *  Error creating bean with name 'arm.iot.sec.configurationclass.config.ConfigTest$Acontroller':
     *  Injection of autowired dependencies failed;
     * */
//    @Scope(value = WebApplicationContext.SCOPE_REQUEST)
//    @Scope(value = "singleton",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public AService aService() {
        return new AServiceImpl();
    }

    @Bean
    public MyPointCut getMYPC(){
        return  new MyPointCut();
    }


    /**
     * Controller
     */


    class MyPointCut implements Pointcut {
        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return MethodMatcher.TRUE;
        }
    }


}
