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
package arm.iot.sec.springUtils.reflect.bean;

import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;

public class BeanA {

    private Interceptor interceptor;
    private String beanName;

    @Bean(name = "12345665")
    public Interceptor getInterceptor() {
        return this.interceptor;
    }

}
