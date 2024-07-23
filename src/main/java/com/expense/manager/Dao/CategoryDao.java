package com.expense.manager.Dao;

import com.expense.manager.entity.Categories;
import com.expense.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Categories,Integer> {

    @Query("SELECT id FROM Categories  WHERE categoryName= :a")
    List<Integer> getByCategoryName2(String a);




}
