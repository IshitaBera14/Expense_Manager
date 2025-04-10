package com.expense.manager.Dao;

import com.expense.manager.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<Transactions,Integer> {


    @Modifying
    @Query(value = "DELETE FROM Transactions WHERE id = :a ",nativeQuery = true)
    void deleteById(@Param("a") Integer a);


    @Query(value = "SELECT * FROM Transactions WHERE id BETWEEN :startId AND :endId",nativeQuery = true)
    List<Transactions> findAllTransactionS(@Param("startId") Integer startId , @Param("endId") Integer endId);


    @Query(value = "SELECT * FROM Transactions  WHERE amount > :amount",nativeQuery = true)
    List<Transactions> getAmountGreaterThan(@Param("amount") Integer a);


    @Query("SELECT t FROM Transactions t WHERE t.date BETWEEN :startDate AND :endDate")
    List<Transactions> findAllByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);


    @Query(value = "SELECT t.note FROM Transactions t ",nativeQuery = true)
    List<String> getAllNotes();


     @Query( "SELECT t.amount FROM Transactions t WHERE t.category.categoryName = :a")
     List<Integer> getByCategoryName(@Param("a") String a);

    // trasaction class in andar mapping kariyu che cagetory id nu aetale cateory j lakhavu pade
    // The colon : is used to denote a named parameter in a JPQL





    @Query(value = "SELECT t.paymentMethod.paymentMethod FROM Transactions t WHERE t.category.categoryName = :s",nativeQuery = true)
    List<String> paymentMethodByCategoryFromDao(String s);


    @Query(value = "SELECT amount FROM Transactions WHERE category.id = :x",nativeQuery = true)
    List<Integer> getByCategoryId(Integer x);

    @Query( "SELECT SUM(amount) FROM Transactions WHERE user.name = :a ")
    List<Integer> getTotalAmountByUser(String a);


    @Query(value ="SELECT c.category_name, SUM(IFNULL(t.amount, 0)) as total_amount " +
                  "FROM categories c " +
                  "LEFT JOIN transactions t ON c.id = t.category_id " +
                  "GROUP BY c.category_name",nativeQuery = true)
    List<Object[]> getTotalAmountCategory();


    @Query(value = "SELECT SUM(t.amount) FROM Transactions t WHERE t.user_id = :userId AND t.date = :date",nativeQuery = true)
    Integer findTotalSpendByUserAndDate(@Param("userId") Integer userId, @Param("date") String date);


    @Query(value = "SELECT c.category_name, SUM(IFNULL(t.amount, 0)) as total_amount " +
            "FROM categories c " +
            "LEFT JOIN transactions t ON c.id = t.category_id " +
            "WHERE t.user_id = :userId AND t.date = :date " +
            "GROUP BY c.category_name", nativeQuery = true)
    List<Object[]> findTotalSpendByUserAndDateByCategory(@Param("userId") Integer userId, @Param("date") String date);

    @Query(value = "SELECT DISTINCT user_id FROM Transactions WHERE date = :date",nativeQuery = true)
    List<Integer> findDistinctUsersByDate(@Param("date") String date);

    @Query(value = "SELECT * FROM Transactions WHERE user_id = :userId AND date =:date" , nativeQuery = true)
    List<Transactions> findByUserIdAndDate(@Param("userId") Integer userId ,@Param("date") String date);
}
