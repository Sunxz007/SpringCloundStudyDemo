package com.sun.springcloud.controller;

import com.sun.springcloud.entities.CommonResult;
import com.sun.springcloud.entities.Payment;
import com.sun.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignServic;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignServic.getPaymentById(id);
    }

    @GetMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        return paymentFeignServic.create(payment);
    }

    @GetMapping("/payment/timeout")
    public String timeoutDemo(){
        return paymentFeignServic.TimeoutDemo();
    }
}
