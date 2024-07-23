package com.expense.manager.service;

import com.expense.manager.Dao.UserDao;
import com.expense.manager.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{

    @Autowired
    UserDao userDao;

    public List<Users> getAllUsers() {
        return userDao.findAll();
    }
    public Users getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }


    public List<Users> getUserOfSpecificName(String nameEnding) {
        return userDao.findByNameStartingWith(nameEnding);
    }

}
