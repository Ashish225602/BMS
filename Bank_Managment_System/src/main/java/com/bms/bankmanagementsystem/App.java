package com.bms.bankmanagementsystem;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bms.bankmanagementsystem.util.HibernateUtil;
import com.bms.bankmanagementsystem.Entity.Coustomer;
import com.bms.bankmanagementsystem.Entity.Account;
import com.bms.bankmanagementsystem.Entity.BankTransaction;

import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        // Initialize session from HibernateUtil
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Start transaction
        Transaction transaction = session.beginTransaction();

        // Step 1: Create a new Customer
        Coustomer customer = new Coustomer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setDateOfBirth("1990-05-20");
        customer.setAddress("123 Main Street, City");
        customer.setPhoneNum("1234567890");
        customer.setCustomerEmail("johndoe@example.com");

        // Step 2: Create a new Account linked to the customer
        Account account = new Account();
        account.setAccountNumber("123456789");
        account.setAccountType("Savings");
        account.setBalance(new BigDecimal("5000.00"));  // Initial balance
        account.setStatus("Active");
        account.setCustomer(customer); // Link account to customer

        // Step 3: Save Customer and Account to the database
        session.save(customer);
        session.save(account);

        // Step 4: Perform a transaction (e.g., deposit)
        BankTransaction depositTransaction = new BankTransaction();
        depositTransaction.setTransactionType("Deposit");
        depositTransaction.setAmount(new BigDecimal("1000.00")); // Using BigDecimal for amount
        depositTransaction.setTransactionDate(new Date());
        depositTransaction.setAccount(account); // Link transaction to account

        // Update account balance after deposit
        account.setBalance(account.getBalance().add(new BigDecimal("1000.00")));

        // Save transaction to the database
        session.save(depositTransaction);

        // Commit transaction
        transaction.commit();

        // Print confirmation
        System.out.println("Customer, Account, and Transaction saved successfully.");
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("New Balance: $" + account.getBalance());

        // Close session
        session.close();

        // Shutdown Hibernate session factory
        HibernateUtil.shutdown();
    }
}
