package com.bank.CommonUser;

import com.bank.CommonUser.Account;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Account Services -get Accounts, updating Accounts
 */
public class AccountService {
    private Repository<Integer, Account> accountRepository;

    public AccountService() {}

    public void setAccountRepository(Repository<Integer, Account> accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {

        return accountRepository.getAll();
    }

    public Account getById(int ac_id) throws IllegalStateException{
        if(ac_id==0) { throw  new IllegalStateException("Account id cannot be 0");}
        else {
            return accountRepository.getById(ac_id);
        }
    }

    public int createAccount(Account newAccount) {

        return accountRepository.save(newAccount);
    }

    public List<Account> updateAccount(int ac_id,int amount) throws NegativeValueException,IllegalArgumentException,IllegalStateException{
        if(amount<0){ throw new IllegalArgumentException("Amount to be deposited cannot be negative");}
        else if(ac_id==0){throw new IllegalStateException("Account id cannot be 0");}
        else {
            return accountRepository.update(ac_id, amount);
        }
    }
    public List<Account> updateWithdraw(int ac_id, int amount) throws IllegalArgumentException{
        if((amount<0)||(amount==0)){ throw new IllegalArgumentException("Amount to be withdrawn cannot be negative or zero");}
        else if(ac_id==0){throw new IllegalStateException("Account id cannot be 0");}
         else {
            return accountRepository.updateWithdraw(ac_id, amount);
        }
    }
    public List<Account> updateTransfer(int ac_id,int ac_id1,int amount) throws IllegalArgumentException{
        if((amount<0)||(amount==0)){ throw new IllegalArgumentException("Amount to be transferred cannot be negative or zero");}
        else if((ac_id==0)||(ac_id1==0)){throw new IllegalStateException("Account id cannot be 0");}
        else {
            return accountRepository.updateTransfer(ac_id, ac_id1, amount);
        }
    }

    public void deleteAccount(int id) {

        accountRepository.delete(id);
    }
    /*

    public Transaction getTransactionById(int ac_id) {
        return null;
        //accountRepository.getTransactionById(ac_id);

    }*/
}

