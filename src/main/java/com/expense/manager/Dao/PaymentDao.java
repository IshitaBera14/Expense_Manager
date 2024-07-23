package com.expense.manager.Dao;

import com.expense.manager.entity.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<PaymentMethods,Integer> {
}
