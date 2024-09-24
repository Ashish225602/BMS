package com.bms.bankmanagementsystem.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ATM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atmId;

    private String location;
    private String bankName;
    private double cashAvailable; // Cash available in the ATM

    // One ATM can have many transactions
    @OneToMany(mappedBy = "atm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BankTransaction> transactions;

    // Getters and Setters

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public Set<BankTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    // Constructors

    public ATM(Long atmId, String location, String bankName, double cashAvailable, Set<BankTransaction> transactions) {
        super();
        this.atmId = atmId;
        this.location = location;
        this.bankName = bankName;
        this.cashAvailable = cashAvailable;
        this.transactions = transactions;
    }

    public ATM() {
        super();
    }

    @Override
    public String toString() {
        return "ATM [atmId=" + atmId + ", location=" + location + ", bankName=" + bankName + ", cashAvailable=" + cashAvailable + "]";
    }
}
