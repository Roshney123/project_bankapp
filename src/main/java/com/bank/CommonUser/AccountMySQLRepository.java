package com.bank.CommonUser;

import com.bank.Main;
import com.bank.utils.DBConnector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AccountMySQLRepository implements Repository<Integer, Account> {
    Logger logger = LoggerFactory.getLogger(AccountMySQLRepository.class);
    private DBConnector connector;

    public AccountMySQLRepository(DBConnector connector) {
        this.connector = connector;
    }

    /** To get all accounts with its details from Database
     * @return All accounts from Database
     */
    @Override
    public List<Account> getAll() {

        List<Account> accounts = new ArrayList<>();
        try (Connection conn = connector.getConnection()) {
            String sql = "call getAllAccounts";// using stored procedure from my sql
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Account a = new Account(
                        rs.getInt("id"),
                        rs.getInt("ac_id"),
                        rs.getString("username"),
                        rs.getString("account_type"),
                        rs.getDouble("balance")
                );
                accounts.add(a);

            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }


    /**
     * To get a single Account with its account number
     * @param ac_id pass id to get Account using unique key from mySql
     * @return account having given ac_id
     */
    @Override
    public Account getById(Integer ac_id) {
        Account account = null;
        try (Connection conn = connector.getConnection()) {
            String sql = "SELECT * FROM Accounts "+"WHERE  ac_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,ac_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            // Account a=rs.getInt("ac_id")==0? null:createAccount(rs);
            Account a= new Account(
                        rs.getInt("id"),
                        rs.getInt("ac_id"),
                        rs.getString("username"),
                        rs.getString("account_type"),
                        rs.getDouble("balance")
                );
                account = a;
            }

            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;

    }

    /**
     * to Create a new Account with the given details and to update it in Account table in the Database
     * @param newAccount Account object to get the details to be inserted to Accounts table
     * @retur newAccount with its account id
     */
    @Override
    public Integer save(Account newAccount) {
        try (Connection conn = connector.getConnection()) {

            String sql = "INSERT INTO Accounts (ac_id,username,account_type,balance)" +
                          "VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,newAccount.ac_id);
            ps.setString(2, newAccount.username);
            ps.setString(3,newAccount.account_type);
            ps.setDouble(4,newAccount.balance);
            ps.executeUpdate();


            return newAccount.ac_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newAccount.ac_id;
    }



    /**
     * use to deposit money to given account with the given amount, update the balance in Account table in the Database
     * @param ac_id to get the account having given account number
     * @return updated account having specified ac_id,updated in DB
     */
    @Override
    public List<Account> update(int ac_id,Integer amount) {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = connector.getConnection()) {

            String sql = "UPDATE Accounts set balance =balance+? WHERE ac_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2,ac_id);
            ps.setInt(1,amount);

            ps.executeUpdate();
            logger.info("hello1"+ac_id);
            String sql3="INSERT INTO transactions (ac_id,tran_type,tran_status) VALUES(?,'Deposit','Success')";

            PreparedStatement ps2 = conn.prepareStatement(sql3);
            logger.info("hello2"+ac_id);
             ps2.setInt(1,ac_id);
            logger.info("hello3"+ac_id);
            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    /**
     * use to withdraw given amount from given account , update balance in Account table accordingly
     * @param ac_id to get the account having given account number
     * @return updated account having specified ac_id,updated in DB
     */
    public List<Account> updateWithdraw(Integer ac_id,Integer amount) {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = connector.getConnection()) {


            String sql = "UPDATE Accounts set balance =balance-? WHERE ac_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2,ac_id);
            ps.setInt(1,amount);

            ps.executeUpdate();
            String sql3="INSERT INTO transactions (ac_id,tran_type,tran_status) VALUES(?,'Withdraw','Success')";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1,ac_id);
            ps3.executeUpdate(sql3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    /**
     * use to transfer  money from  account ac_id to ac_id1,update balance of both accounts in DB accordingly
     * @param ac_id ,ac_id1 to get the accounts with specified account numbers
     * @return update the DB accordingly
     */
    public List<Account> updateTransfer(Integer ac_id,Integer ac_id1,Integer amount) {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = connector.getConnection()) {


            String sql = "UPDATE Accounts SET balance =balance-? WHERE ac_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2,ac_id);
            ps.setInt(1,amount);
            ps.executeUpdate();

            String sql3 = "UPDATE Accounts SET balance =balance+? WHERE ac_id=?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(2,ac_id1);
            ps3.setInt(1,amount);
            ps3.executeUpdate();

            String sql2="INSERT into transactions (ac_id,tran_type,tran_status) values(?,'Withdraw','Success')";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1,ac_id);
            ps2.executeUpdate();
            String sql4="INSERT into transactions (ac_id,tran_type,tran_status) values(?,'Deposit','Success')";
            PreparedStatement ps4 = conn.prepareStatement(sql4);
            ps4.setInt(1,ac_id1);
            ps4.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void delete(Integer integer) {

    }


    /*public List<Transaction> getTransactionById(int ac_id) {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = connector.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE ac_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,ac_id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Transaction t = new Transaction(
                        rs.getInt("tran_id"),
                        rs.getInt("ac_id"),
                        rs.getString("tran_type"),
                        rs.getString("tran_status")

                );
                transactions.add(t);

            }
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }*/

}

