package com.expense.manager.controller;

import com.expense.manager.entity.Transactions;
import com.expense.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController
{
    @Autowired
    TransactionService transactionService;                              // Type Declaration && variable name

                                                                         /*  @GetMapping ("/show")
                                                                             public String addQuestion(){ return "ABC1"; }*/
    @PostMapping("/addNewData")
    public Transactions addNewData(@RequestBody Transactions transactions)
    {
        return transactionService.addData(transactions);
    }

    @DeleteMapping("/deleteUserData/{id}")
    public void deleteData(@PathVariable Integer id)
    {
        transactionService.deleteTransaction(id);
    }

    @GetMapping("/getAllTransaction")
    public List<Transactions> getAllTransactions()
    {
        return transactionService.getTransaction();
    }


    @GetMapping("/get/{startId}/{endId}")
    public List<Transactions> getRangeOfTransactionIds(@PathVariable Integer startId ,@PathVariable Integer endId)
    {
        return transactionService.getRangeOfTransactionId(startId, endId);
    }


    @GetMapping("/amount/{id}")
    public List<Transactions> getTransactionsByAmountsGreaterThan(@PathVariable Integer id)
    {                                                                                                      //  System.out.print("<------------1----------->" );
         return transactionService.getTransactionsByAmountGreaterThan(id);                            // for checking that controller ma request ave che ke nahi
    }

    @GetMapping("/getDateBySpecificRange")
    public List<Transactions> getDateBySpecificRange(@RequestParam("a") @DateTimeFormat(pattern = "dd/MM/yyyy") String a,
                                       @RequestParam("b")  @DateTimeFormat(pattern = "dd/MM/yyyy") String b)
    {
         return transactionService.getDateByRange(a,b);
    }

    @GetMapping("/getColumnOfNotes")
    public List<String> columnOfNotes()
    {
        return transactionService.columnOfNote();

    }

    @GetMapping("/AmountsByCategory")                                                 //categories table mathi food category ma trasaction table mathi amount find karva mate
    public List<Integer> getAmountCategories(@RequestParam("category") String a)      // a means tiya categoryName avse
    {
        return transactionService.getAmountCategory(a);
    }

    @GetMapping("/getPaymentMethodByCategory")                                               // categories table mathi food (category) nu payment kay method thi thayu ae find karva mat
    public List<String> paymentMethodByCategory(@RequestParam("category") String a)
    {
        return transactionService.paymentMethodByCategoryFromService(a);

    }
    @GetMapping("/getByCategory")
    public List<Integer> getAmountCategories2(@RequestParam("category") String a)
    {
        return transactionService.getAmountCategory2(a);
    }

    @GetMapping("/getTotalAmountByUser")
    public List<Integer> getTotalAmountByUser(@RequestParam("user") String a)
    {
        return transactionService.getTotalAmountByUsers(a);
    }

    @GetMapping("/totalByCategory")
    public List<Object[]> getTotalAmountGroupedByCategorys()
    {
        return transactionService.getTotalAmountGroupedByCategory();
    }



}

