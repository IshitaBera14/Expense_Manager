package com.expense.manager.controller;

import com.expense.manager.entity.Categories;
import com.expense.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("categorydata")
    public List<Categories> getcategorys()
    {
        return categoryService.getcategory();
    }

   /* @GetMapping("food")
    public List<Categories> getCategoryByFood()
    {
        List<Categories> a = categoryService.getFoodCategory();

        return a;
    }*/


}
