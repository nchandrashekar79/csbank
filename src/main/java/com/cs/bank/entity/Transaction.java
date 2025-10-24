package com.cs.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // Marks the class as a JPA entity
public class Transaction {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key to be auto-generated
    @Column(name = "transaction_id")
    private Integer transactionID;

    // VARCHAR(20) is mapped to String
    // Note: This is denormalized as per Note #2
    @Column(name = "transaction_type", length = 20, nullable = false)
    private String transactionType;

    // DECIMAL(10, 2) is mapped to BigDecimal for precision
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    // DATETIME is mapped to java.time.LocalDateTime
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    // Note: Relationships to Account, other Transaction, Employee, and LoanPayment are omitted as requested by Note #1.

    /**
     * Default constructor required by JPA.
     */
    public Transaction() {
    }

    /**
     * Parameterized constructor for convenience.
     */
    public Transaction(String transactionType, BigDecimal amount, LocalDateTime transactionDate) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // --- Getters and Setters ---

    public Integer getTransactionID() {
        return transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}