package com.cs.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @Column(unique = true, nullable = false, length = 100)
    private String branchName;

    @Column(unique = true, nullable = false, length = 10)
    private String branchCode;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    // Default constructor
    public Branch() {
    }

    // Constructor with all parameters
    public Branch(String branchName, String branchCode, String address, String phoneNumber) {
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
