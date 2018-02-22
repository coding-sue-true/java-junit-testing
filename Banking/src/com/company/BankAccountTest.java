package com.company;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    private com.company.BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This runs before any test class. Count = " + count++);
    }

    @Before
    public void setup(){
        account = new com.company.BankAccount("Tim", "Buchalka", 1000.00,  com.company.BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() throws Exception {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test // (expected = IllegalArgumentException.class)
    // if the line above was not commented out, we wouldn't need the try and catch expressions
    public void withdraw_notBranch() throws Exception {
        try {
            account.withdraw(600.00, false);
            //message in case it fails
            fail("Should have thrown an IllegalArgumentException");
        } catch(IllegalArgumentException e) {

        }
    }

    @Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() throws Exception {
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This runs after any test class. Count = " + count++);
    }

    @After
    public void teardown(){
        System.out.println("Count = " + count++);
    }


}