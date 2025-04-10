package com.expense.manager.service;

import com.expense.manager.entity.Transactions;
import com.expense.manager.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.math.BigDecimal;

@Service
public class Cron
{
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EmailService emailService;



    // @Scheduled(cron  = "0 */2 * * * *")
    public void sendDailyEmails() {
         System.out.println("<---------------1---------------->");
        List<Users> users = userService.getAllUsers();

        for (Users user : users) {
            emailService.sendEmail(user.getEmail(), "Daily Reminder", "This is your daily email!");
        }
    }

   // @Scheduled(cron = "0 12 10 * * *")
    public void sendDailyEmailsToUserOfTheirTotalSpend()
    {
        List<Users> users = userService.getAllUsers();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String formattedDate = yesterday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (Users user : users)
        {
            int totalSpend = transactionService.getTotalSpendByUserAndDate(user.getId(), formattedDate);
            String emailContent = "Hello " + user.getName() + ",\n\nYour total spend for " + formattedDate + " was: $" + totalSpend + ".\n\nBest Regards,\nExpense Manager Team";
            emailService.sendEmail(user.getEmail(), "Your Daily Expense Report", emailContent);
        }
    }

    @Scheduled(cron = "0 35 19 * * *")
    public void sendDailyEmailsToUserOfTheirTotalSpendWithCategory()
    {

        List<Users> a = userService.getAllUsers();
        LocalDate yesDay = LocalDate.now().minusDays(1);
        String DateFormat = yesDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for(Users i: a)
        {
                List<Object[]> totalSpend = transactionService.getTotalSpendByUserAndDateByCategory(i.getId(), DateFormat);
                StringBuilder emailContent = new StringBuilder("Hello " + i.getName() + ",\n\nYour total spend for " + DateFormat + " was:\n");


                for (Object[] categorySpend : totalSpend)
                {
                    String category = (String) categorySpend[0];
                 //   Integer amount = (Integer) categorySpend[1];
                    BigDecimal amount = (BigDecimal) categorySpend[1];
                    emailContent.append(category).append(": $").append(amount).append("\n");

                }
                emailContent.append("\nBest Regards,\nExpense Manager Team");
                emailService.sendEmail(i.getEmail(), "Your Daily Expense Report with Categories", emailContent.toString());
        }
    }

    @Scheduled(cron = "0 36 19 * * *")
    public void sendEmailToThoseWhoHasTransactionOnPreviousDay()
    {
        LocalDate previousDate =LocalDate.now().minusDays(1);
        String DateFormat = previousDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Integer> userId = transactionService.getUsersWithTransactionsOnDate(DateFormat);

        System.out.println(userId);

        for(Integer i : userId)
        {
            Users user = userService.getUserById(i);
            List<Transactions> transactions = transactionService.getTransactionsByUserIdAndDate(i,DateFormat);
            StringBuilder emailContent = new StringBuilder("Dear " + user.getName() + ",\n\nHere are your transactions from yesterday:\n\n");

            for( Transactions transaction : transactions)
            {
                emailContent.append("Category: ").append(transaction.getCategory())
                        .append(", Amount: ").append(transaction.getAmount()).append("\n");

            }
            emailContent.append("\nBest regards,\nYour Expense Manager");
            emailService.sendEmail(user.getEmail(), "Your Transactions from Yesterday", emailContent.toString());
        }
    }



}




