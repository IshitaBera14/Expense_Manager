package com.expense.manager.controller;

import com.expense.manager.entity.Users;
import com.expense.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/getUserFromSpecificLetter")
    public List<Users> getUserOfSpecificLetter(@RequestParam("letter") String letter) {
        return userService.getUserOfSpecificName(letter);
    }


}
