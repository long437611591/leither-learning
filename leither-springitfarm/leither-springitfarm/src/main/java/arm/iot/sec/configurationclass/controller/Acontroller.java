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
package arm.iot.sec.configurationclass.controller;

import arm.iot.sec.configurationclass.config.ConfigTest;
import arm.iot.sec.proxy.jdkdynamic.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class Acontroller {

    AService aService;

    @Autowired
    public void setaService(AService aService) {
        this.aService = aService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> get() {
        System.out.println("let us look on the injected service: " + aService);
        return ResponseEntity.ok().build();
    }
}

