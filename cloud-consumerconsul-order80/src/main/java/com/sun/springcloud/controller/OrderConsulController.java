package com.sun.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sun
 */
@Slf4j
@RestController
public class OrderConsulController {

    public static final String INVOKE_UROL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPaymentInfo(){
        return restTemplate.getForObject(INVOKE_UROL+"/payment/consul", String.class);
    }
}
