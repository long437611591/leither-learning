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
package arm.iot.sec.aop.api.advice;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class DemoIntroductionAdvice extends DelegatingIntroductionInterceptor implements  Runnable {

    @Override
    public void run() {
        System.out.println("now DemoIntroductionAdvice running ");
    }
}
