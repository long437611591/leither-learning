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
package arm.sec.iot.functionalInter.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Setter
@Getter
public class BeanA {

    private String firstName;
    private String lastName;
    private Integer age;
    private Map<String,Double>  scores;

}
