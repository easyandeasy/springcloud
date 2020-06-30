package com.tang.springcloud.dao;

import com.tang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);
}
