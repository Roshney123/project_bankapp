package com.bank.CommonUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountInMemRepository implements Repository<Integer, Account> {

    private List<Account> accounts = new ArrayList<>();
       private IdGenerator idGenerator;

    public AccountInMemRepository(IdGenerator idGen) {
        this.idGenerator = idGen;
    }

    @Override
    public List<Account>getAll() {
        return accounts;
    }

    @Override
    public Account getById(Integer ac_id) {
       /* return accounts.stream()
                .filter(g -> g.getId()== id)
                .findFirst();*/
                return null;
    }

    @Override
    public Integer save(Account newAccount) {
        return newAccount.ac_id;
        /*int id = idGenerator.nextId();
        obj.setId(id);
        accounts.add(obj);
        return id;*/
    }

    @Override
    public List<Account> update(int ac_id,Integer amount) {
    return accounts;
    }
    @Override
    public List<Account> updateWithdraw(Integer ac_id,Integer amount) {
        return accounts;
    }
    @Override
    public List<Account> updateTransfer(Integer ac_id,Integer ac_id1,Integer amount) {
        return accounts;
    }

    @Override
    public void delete(Integer integer) {

    }

    /*public List<Transaction> getTransactionById(int ac_id) {
        return transactions;
    }*/
}
