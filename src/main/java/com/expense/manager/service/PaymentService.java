package com.expense.manager.service;

import com.expense.manager.Dao.PaymentDao;
import com.expense.manager.Dao.UserDao;
import com.expense.manager.entity.PaymentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public List<PaymentMethods> getPayment()
    {
        return paymentDao.findAll();
    }
}
