package com.cs.bank.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testAccountGettersAndSetters() {
        Account account = new Account();

        // Test accountId
        account.setAccountId(1L);
        assertEquals(1L, account.getAccountId());

        // Test customer
        Customer customer = new Customer();
        account.setCustomer(customer);
        assertEquals(customer, account.getCustomer());

        // Test branch
        Branch branch = new Branch();
        account.setBranch(branch);
        assertEquals(branch, account.getBranch());

        // Test accountType
        account.setAccountType("Savings");
        assertEquals("Savings", account.getAccountType());

        // Test accountNumber
        account.setAccountNumber("123456789");
        assertEquals("123456789", account.getAccountNumber());

        // Test currentBalance
        BigDecimal balance = new BigDecimal("1000.00");
        account.setCurrentBalance(balance);
        assertEquals(balance, account.getCurrentBalance());

        // Test dateOpened
        Date dateOpened = new Date();
        account.setDateOpened(dateOpened);
        assertEquals(dateOpened, account.getDateOpened());

        // Test dateClosed
        Date dateClosed = new Date();
        account.setDateClosed(dateClosed);
        assertEquals(dateClosed, account.getDateClosed());

        // Test accountStatus
        account.setAccountStatus("Active");
        assertEquals("Active", account.getAccountStatus());
    }
}
