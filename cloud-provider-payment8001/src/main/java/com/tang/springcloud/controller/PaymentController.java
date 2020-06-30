package com.tang.springcloud.controller;

import com.tang.springcloud.entities.CommonResult;
import com.tang.springcloud.entities.Payment;
import com.tang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLOutput;

@RestController
@Slf4j
//@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
//        Log.info();
        if(result > 0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(500,"插入数据库失败",result);
        }
    }



    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
//        Log.info();
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(500,"没有对应记录，查询id=" + id,payment);
        }
    }
}
