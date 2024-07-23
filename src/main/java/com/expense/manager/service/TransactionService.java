package com.expense.manager.service;


import com.expense.manager.Dao.CategoryDao;
import com.expense.manager.Dao.TransactionDao;
import com.expense.manager.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService
{
    @Autowired
    TransactionDao transactionDao;

    @Autowired
    CategoryDao categoryDao;

    public Transactions addData(Transactions transactions) {
       return transactionDao.save(transactions);
    }


    public void deleteTransaction(Integer id) {
        transactionDao.deleteById(id);
    }

    public List<Transactions> getTransaction()
    {
        return transactionDao.findAll();
    }

    public List<Transactions> getRangeOfTransactionId(Integer startId , Integer endId) {
        return transactionDao.findAllTransactionS(startId, endId);
    }
       /* List<Transactions> filteredTransactions = new ArrayList<>();

        for (Transactions transaction : allTransactions)
        {
            if (transaction.getId() >= startId && transaction.getId() <= endId)
            {
                filteredTransactions.add(transaction);
            }
        }*/




    public List<Transactions> getTransactionsByAmountGreaterThan(Integer a )
    {                                                                      // System.out.print("2"+a);
        return transactionDao.getAmountGreaterThan(a);                  // for checking that the value of a  is coming in the Service layer
     /*   List<Transactions> ans = new ArrayList<>();

        for(Transactions i : nn)
        {
            if(i.getAmount() >= a  )
            {
                ans.add(i);
            }
        }*/

    }


    public List<Transactions> getDateByRange(String a, String b) {
        return transactionDao.findAllByDateRange(a,b);
      /*  List<Transactions> ansDate = new ArrayList<>();

        for(Transactions i : allDate)
        {
            if(i.getDate().compareTo(a) >= 0 && i.getDate().compareTo(b) <= 0)
            {
                ansDate.add(i);
            }
        }
        return ansDate;*/
    }

    public List<String> columnOfNote()
    {
        return transactionDao.getAllNotes();
    }

    public List<Integer> getAmountCategory(String a)
    {
        return transactionDao.getByCategoryName(a);
    }

    public List<String> paymentMethodByCategoryFromService(String aa)
    {
        return transactionDao.paymentMethodByCategoryFromDao(aa);
    }
    public List<Integer> getAmountCategory2(String a)
    {
        List<Integer> x = categoryDao.getByCategoryName2(a);
        return transactionDao.getByCategoryId(x.get(0));

    }

    public List<Integer> getTotalAmountByUsers(String a)
    {
        return transactionDao.getTotalAmountByUser(a);
    }

    public List<Object[]> getTotalAmountGroupedByCategory()
    {
        return transactionDao.getTotalAmountCategory();
    }



    public int getTotalSpendByUserAndDate(Integer userId, String date) {
        Integer totalSpend = transactionDao.findTotalSpendByUserAndDate(userId, date);
        return totalSpend != null ? totalSpend : 0;
    }

    public List<Object[]> getTotalSpendByUserAndDateByCategory(Integer userId, String date) {
        return transactionDao.findTotalSpendByUserAndDateByCategory(userId, date);

    }

    public List<Integer> getUsersWithTransactionsOnDate(String date){
        return transactionDao.findDistinctUsersByDate(date);
    }

    public List<Transactions> getTransactionsByUserIdAndDate(Integer userId , String date){
        return transactionDao.findByUserIdAndDate(userId , date);
    }

}

