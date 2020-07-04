package luckye.service.impl;

import com.luckye.entities.Payment;
import luckye.dao.PaymentDao;
import luckye.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;
    @Override
    public boolean  create(Payment payment) {
        return paymentDao.createPayment(payment)>0 ? true:false;
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentDao.findPaymentById(id);
    }
    @Override
    public boolean deletPaymentById(Long id) {
        return paymentDao.deletePaymentById(id)==0?true:false;
    }
}
