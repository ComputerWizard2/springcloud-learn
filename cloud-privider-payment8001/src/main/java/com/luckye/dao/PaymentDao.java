package com.luckye.dao;

import com.luckye.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public  Integer createPayment(Payment payment);

    public Payment findPaymentById(@Param("id") Long id);

    public Integer deletePaymentById(@Param("id")Long id);
}
