package com.bms.bankmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private Long accountNumber;
    private String firstName;
    private String lastName;
    private String accountType;
    private String dateOfBirth;
    private String address;
    private String phoneNum;
    private String customerEmail;

    // Getters and Setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Coustomer [customerId=" + customerId + ", accountNumber=" + accountNumber + ", firstName=" + firstName
                + ", lastName=" + lastName + ", accountType=" + accountType + ", dateOfBirth=" + dateOfBirth
                + ", address=" + address + ", phoneNum=" + phoneNum + ", customerEmail=" + customerEmail + "]";
    }

    // Constructors

    public Coustomer(Long customerId, Long accountNumber, String firstName, String lastName, String accountType,
            String dateOfBirth, String address, String phoneNum, String customerEmail) {
        super();
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNum = phoneNum;
        this.customerEmail = customerEmail;
    }

    public Coustomer() {
        super();
    }
}
