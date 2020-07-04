package com.luckye.service;

import com.luckye.entities.Payment;

public interface PaymentService {

    public boolean create(Payment payment);

    public Payment findPaymentById(Long id);

    public  boolean deletPaymentById(Long id);

}
