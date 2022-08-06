package com.bank.CommonUser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @param <ID> Integer
 * @param <E> Account
 */
public interface Repository<ID, E> {
    List<E> getAll();
    E getById(ID ac_id);
    Integer save(E newAccount);
    List<E> update(int ac_id,ID amount);
    List<E>updateWithdraw(ID ac_id,ID amount);
    List<E>updateTransfer(ID ac_id,ID ac_id1,ID amount);
    void delete(ID id);
    //List<E>getTransactionById(ID ac_id);
}
