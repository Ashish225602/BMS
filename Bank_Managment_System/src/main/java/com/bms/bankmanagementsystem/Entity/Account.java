package com.bms.bankmanagementsystem.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private String accountType; // e.g., Savings, Checking
    private BigDecimal balance; // Change from double to BigDecimal
    private String status; // e.g., Active, Closed, Suspended

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Coustomer customer; // Fixed typo: "Coustomer" to "Customer"

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BankTransaction> transactions; // Set of transactions for this account

    // Getters and Setters

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Coustomer getCustomer() {
        return customer;
    }

    public void setCustomer(Coustomer customer) {
        this.customer = customer;
    }

    public Set<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    // Constructors

    public Account() {
        super();
    }

    public Account(Long accountId, String accountNumber, String accountType, BigDecimal balance, String status, Coustomer customer) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
                + ", balance=" + balance + ", status=" + status + ", customer=" + customer + "]";
    }
}
