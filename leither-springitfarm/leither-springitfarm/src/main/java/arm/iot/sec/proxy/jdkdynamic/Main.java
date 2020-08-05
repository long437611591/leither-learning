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
package arm.iot.sec.proxy.jdkdynamic;

import arm.iot.sec.proxy.jdkdynamic.handler.AInvocationhandler;
import arm.iot.sec.proxy.jdkdynamic.service.AService;
import arm.iot.sec.proxy.jdkdynamic.service.impl.AServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.time.temporal.ValueRange;

public class Main {

    public static void main(String[] args)  {
        AServiceImpl target = new AServiceImpl();
        Class<? extends AServiceImpl> clazz = target.getClass();
        AService instance = (AService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new AInvocationhandler(target));
        instance.test01();
        instance.test02("123");

        byte[] proxyData = ProxyGenerator.generateProxyClass("proxy", clazz.getInterfaces());

        File file = new File("C:\\Leither\\Material" +
                "\\Learning\\leither-basic\\" +
                "leither-springitfarm\\leither-springitfarm" +
                "\\src\\main\\java\\resources\\proxy.class");

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(proxyData, 0, proxyData.length);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                }
            }
        }


    }
}
