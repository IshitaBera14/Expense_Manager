package com.expense.manager.service;

import com.expense.manager.Dao.CategoryDao;
import com.expense.manager.entity.Categories;
import com.expense.manager.entity.PaymentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Categories> getcategory()
    {
        return categoryDao.findAll();
    }


}
