package com.bank.tests;

import com.bank.CommonUser.Account;
import com.bank.CommonUser.AccountMySQLRepository;
import com.bank.CommonUser.AccountService;
import com.bank.CommonUser.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AccountServiceTests {
    public IdGenerator idGen;
    public AccountService service;

    @BeforeEach
    public void init() {
        System.out.println("Initializing before test");
        idGen = new TestIdGenerator();//can use SkipStepIdGenerator or SequentialIdGenerator
        service = new AccountService();
        // service= new AccountService();
       ;
    }

    @Test
    public void shouldThrowIllegalStateException() {
        IllegalStateException ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.getById(0);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");
        ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.updateAccount(0,50);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");
        ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.updateWithdraw(0,100);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");

        ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.updateTransfer(0,0,50);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");
        ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.updateTransfer(17,0,50);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");
        ex=Assertions.assertThrows(IllegalStateException.class,()->{
            service.updateTransfer(0,17,50);
        });
        Assertions.assertEquals("Account id cannot be 0", ex.getMessage(), "Can't throw null value for account id");

    }

    @Test
    public void shouldThrowNegativeValueException() {
        IllegalArgumentException ex=Assertions.assertThrows(IllegalArgumentException.class,()->{
            service.updateAccount(17,-5);
        });
        Assertions.assertEquals("Amount to be deposited cannot be negative", ex.getMessage(), "Can't throw negative value for amount to be deposited");

    }
    @Test
    void shouldThrowIllegalArgumentException(){
        IllegalArgumentException ex=Assertions.assertThrows(IllegalArgumentException.class,()->{
            service.updateWithdraw(17,-4);
        });
        Assertions.assertEquals("Amount to be withdrawn cannot be negative or zero", ex.getMessage(), "Can't throw negative or zero value for amount ");

        ex=Assertions.assertThrows(IllegalArgumentException.class,()->{
            service.updateWithdraw(17,0);
        });
        Assertions.assertEquals("Amount to be withdrawn cannot be negative or zero", ex.getMessage(), "Can't throw negative or zero value for amount ");

    }
    @Test
    void shouldThrowIllegalAmountException(){
        IllegalArgumentException ex=Assertions.assertThrows(IllegalArgumentException.class,()->{
            service.updateTransfer(17,18,-3);
        });
        Assertions.assertEquals("Amount to be transferred cannot be negative or zero", ex.getMessage(), "Can't throw negative or zero value for amount ");

        ex=Assertions.assertThrows(IllegalArgumentException.class,()->{
            service.updateTransfer(17,18,0);
        });
        Assertions.assertEquals("Amount to be transferred cannot be negative or zero", ex.getMessage(), "Can't throw negative or zero value for amount ");

    }
}

class TestIdGenerator implements IdGenerator{
    @Override
    public int currentId() {
        return 1;
    }

    @Override
    public int nextId() {
        return 2;// here we got control over idGeneration
    }
}