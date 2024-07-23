package com.expense.manager.Dao;

import com.expense.manager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDao extends JpaRepository<Users,Integer> {

   @Query(value = "SELECT * FROM Users WHERE name LIKE :nameStarting% ",nativeQuery = true)
   List<Users> findByNameStartingWith(@Param("nameStarting") String nameStarting);

   // all name that has s in that
    // @Query(value = "SELECT * FROM Users WHERE name LIKE CONCAT('%', :nameStarting, '%')", nativeQuery = true)
  //  List<Users> findByNameStartingWith(@Param("nameStarting") String nameStarting);

}
