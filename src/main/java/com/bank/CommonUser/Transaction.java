package com.bank.CommonUser;

import java.util.HashMap;
import java.util.Map;

/**
 * POM Model for transaction
 */
public class Transaction {
    int tran_id;
    String tran_type;
    int ac_id;
    String tran_status;


    public Transaction() {
    }

    public Transaction(int tran_id,int ac_id, String tran_type,String tran_status) {
        this.tran_id = tran_id;
        this.tran_type = tran_type;
        this.ac_id = ac_id;
        this.tran_status = tran_status;
    }

    public int getTran_id() {
        return tran_id;
    }

    public void setTran_id(int tran_id) {
        this.tran_id = tran_id;
    }

    public String getTran_type() {
        return tran_type;
    }

    public void setTran_type(String tran_type) {
        this.tran_type = tran_type;
    }

    public int getAc_id() {
        return ac_id;
    }

    public void setAc_id(int ac_id) {
        this.ac_id = ac_id;
    }

    public String getTran_status() {
        return tran_status;
    }

    public void setTran_status(String tran_status) {
        this.tran_status = tran_status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tran_id=" + tran_id +
                ", tran_type='" + tran_type + '\'' +
                ", ac_id=" + ac_id +
                ", tran_status='" + tran_status + '\'' +
                '}';
    }
}
