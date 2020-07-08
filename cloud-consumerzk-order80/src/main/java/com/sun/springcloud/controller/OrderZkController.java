package com.sun.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sun
 */
@RestController
@Slf4j
public class OrderZkController {
    public static final String INVOKE_UROL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentInfo(){
        return restTemplate.getForObject(INVOKE_UROL+"/payment/zk", String.class);
    }
}
