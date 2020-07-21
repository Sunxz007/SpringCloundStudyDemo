package com.sun.springcloud.controller;

import com.sun.springcloud.entities.CommonResult;
import com.sun.springcloud.entities.Payment;
import com.sun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@ResponseBody
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果" + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****获取结果：" + payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功~" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询id：" + id, null);
        }
    }

    /**
     * 模拟长时连接方法
     * @return 端口号
     */
    @GetMapping("/payment/timeout")
    public String TimeoutDemo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
}
