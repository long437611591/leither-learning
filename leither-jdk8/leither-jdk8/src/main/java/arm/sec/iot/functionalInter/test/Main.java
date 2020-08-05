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
package arm.sec.iot.functionalInter.test;

import arm.sec.iot.functionalInter.beans.BeanA;
import arm.sec.iot.functionalInter.utils.JavaUtils;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        BeanA beanA = new BeanA();
        test01(beanA);
        
    }

    private static void test01(BeanA beanA) {

        JavaUtils javaUtils = JavaUtils.INSTANCE;

        HashMap<String, Double> score = new HashMap<>();

        javaUtils.acceptIfNotNull("Lily",beanA::setFirstName)
                 .acceptIfNotNull("Wu",beanA::setLastName)
                 .acceptIfNotNull(score,beanA::setScores)
                 .acceptIfNotNull(123,beanA::setAge);

    }


}
