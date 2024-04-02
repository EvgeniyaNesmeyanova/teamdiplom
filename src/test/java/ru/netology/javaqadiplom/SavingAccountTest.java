package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(5_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());

    }
    @Test
    public void shouldShowExceptionMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2000, -1000, 10000, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(2000, 11000, 10000, 5));
    }
    @Test
    public void shouldShowExceptionInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(500,1000, 10000, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SavingAccount(11000,1000, 10000, 5));
    }
    @Test
    public void addValidAmount() {
        SavingAccount savingAccount = new SavingAccount(2000, 1000, 6000, 10);
        assertTrue(savingAccount.add(1000));
        Assertions.assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void addMaxValidAmount() {
        SavingAccount savingAccount = new SavingAccount(2000, 1000, 6000, 10);
        Assertions.assertTrue(savingAccount.add(4000));
        Assertions.assertEquals(6000, savingAccount.getBalance());
    }

    @Test
    public void payInvalidAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.pay(2500));
        Assertions.assertEquals(500, savingAccount.getBalance());
    }

    @Test
    public void addNegativeAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.add(-1000));
        Assertions.assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void payValidAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 5);
        assertTrue(savingAccount.pay(1000));
        Assertions.assertEquals(2000, savingAccount.getBalance());
    }

    @Test
    public void payValidAmountMin() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertTrue(savingAccount.pay(1000));
        Assertions.assertEquals(2000, savingAccount.getBalance());
    }


    @Test
    public void payNegativeAmount() {
        SavingAccount savingAccount = new SavingAccount(3000, 1000, 5000, 10);
        assertFalse(savingAccount.pay(-500));
        Assertions.assertEquals(3000, savingAccount.getBalance());
    }

    @Test
    public void yearChange() {
        SavingAccount savingAccount = new SavingAccount(200, 0, 5000, 15);
        double balance = savingAccount.yearChange();
        Assertions.assertEquals(30, balance);
    }


}


















