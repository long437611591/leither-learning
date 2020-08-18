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
package arm.sec.iot.functionalInter.utils;

import java.util.function.Consumer;

public final class JavaUtils {

    public static final JavaUtils INSTANCE = new JavaUtils();

    private JavaUtils() {
    }

    public <T> JavaUtils acceptIfCondition(boolean condition, T value, Consumer<T> consumer) {
        if (condition) {
            consumer.accept(value);
        }
        return this;
    }

    public  <T> JavaUtils acceptIfNotNull(T value,Consumer<T> consumer){

        if (value != null){
            consumer.accept(value);
        }
        return  this;
    }

}
