package com.bms.bankmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String loanType;
    private BigDecimal loanAmount;  // Using BigDecimal to handle monetary values
    private String duration;  // e.g., "10 years" or "120 months"

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Coustomer customer;  // Foreign key relationship with Customer entity

    // Getters and Setters

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Coustomer getCustomer() {
        return customer;
    }

    public void setCustomer(Coustomer customer) {
        this.customer = customer;
    }

   

    public loan(Long loanId, String loanType, BigDecimal loanAmount, String duration, Coustomer customer) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.duration = duration;
		this.customer = customer;
	}
    

	// toString method

    public loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", duration=" 
                + duration + ", customer=" + customer + "]";
    }
}
