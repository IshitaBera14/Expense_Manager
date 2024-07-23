package com.expense.manager.controller;

import com.expense.manager.entity.PaymentMethods;
import com.expense.manager.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("paymentdata")
    public List<PaymentMethods> getPayments()
    {
        return paymentService.getPayment();
    }
}
