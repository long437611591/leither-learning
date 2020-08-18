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
package arm.iot.sec.proxy.jdkdynamic.service.impl;

import arm.iot.sec.proxy.jdkdynamic.service.AService;

public class AServiceImpl implements AService {

    @Override
    public void test01() {
        System.out.println("test01");
    }

    @Override
    public void test02(String s) {
        System.out.println(s);
    }
}