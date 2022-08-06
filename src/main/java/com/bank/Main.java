package com.bank;


import com.bank.CommonUser.*;
import com.bank.utils.DBConnector;
import com.bank.utils.MySQLConnector;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Controller of the Bank application
 */
public class Main {

    //public static final Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
       /*Welcome myApp= new Welcome();// just to print a welcome msg
        myApp.run();
        Scanner scanner= new Scanner(System.in);
        Login l=new Login();
        l.doLogin(scanner);
*/
       /* AccountServiceImpl u= new AccountServiceImpl();        ;
        u.getAccount();
        u.postAccount();
        u.viewBalance();
        u.depositMoney();
        u.withdrawMoney();
        u.transferMoney();

        */
        DBConnector mysqlDB= new MySQLConnector("root","Roshney@123","jdbc:mysql://34.130.116.68:3306/Accounts");
        /*try{
            Connection c= mysqlDB.getConnection();
            if(c!=null){
                System.out.println("Connected to Database");
                c.close();

            }
            else{
                System.out.println("Not connected to Database");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }*/

        IdGenerator idGen = new SequentialIdGenerator(1);
        Repository<Integer, Account> accountRepository = new AccountMySQLRepository(mysqlDB);
        AccountService accountService = new AccountService();
        accountService.setAccountRepository(accountRepository); // setter injection



       Logger logger = LoggerFactory.getLogger(Main.class);
       logger.info("Creating Javalin application");

        Javalin app =  Javalin
                .create()
                .start(8081);


        Account a=accountRepository.getById(1);
        app.get("/accounts", (ctx) -> {
            ctx.contentType("application/json");
            ctx.json(accountService.getAllAccounts());
        });


        app.get("/accounts/view/{ac_id}", (ctx) -> {// String to integer
                    int ac_id = Integer.parseInt(ctx.pathParam("ac_id"));
                    ctx.header("Location", String.valueOf(new URI("http://localhost:8081/accounts/" + ac_id)));
                    Account g = accountService.getById(ac_id);

                    if (g != null) {
                        ctx.status(200);
                        ctx.contentType("application/json");
                        ctx.json(accountService.getById(ac_id));
                        //ctx.result("Account balance:" + g.balance);
                        return;
                    }
                    ctx.status(404);
                    ctx.result("Account not found");

                });

        app.post("/accounts", (ctx) -> {
            Account newAccount = ctx.bodyAsClass(Account.class);
            accountService.createAccount(newAccount);

            ctx.contentType("application/json");
            ctx.status(201);
            //ctx.json(newAccount);
            ctx.result("New Account created");
            ctx.header("Location", String.valueOf(new URI("http://localhost:8081/accounts/")));//if we return 201,no content

        });


        app.put("/accounts/{ac_id}/{amount}", (ctx) -> {
            //Account newAccount = ctx.bodyAsClass(Account.class);
            int ac_id = Integer.parseInt(ctx.pathParam("ac_id"));
            int amount = Integer.parseInt(ctx.pathParam("amount"));
            ctx.header("Location", String.valueOf(new URI("http://localhost:8081/accounts/" + ac_id+amount)));

            accountService.updateAccount(ac_id,amount);
            ctx.result("Amount Deposited Successfully");
            ctx.status(204);
        });
        app.put("/accounts/withdraw/{ac_id}/{amount}", (ctx) -> {
            //  Account account = ctx.bodyAsClass(Account.class);
            int ac_id = Integer.parseInt(ctx.pathParam("ac_id"));
            int amount = Integer.parseInt(ctx.pathParam("amount"));
            ctx.header("Location", String.valueOf(new URI("http://localhost:8081/accounts/" + ac_id+amount)));

            accountService.updateWithdraw(ac_id,amount);
            ctx.result("Amount withdrawn Successfully");
            ctx.status(204);
        });
        app.put("/accounts/transfer/{ac_id}/{ac_id1}/{amount}", (ctx) -> {
            //  Account account = ctx.bodyAsClass(Account.class);
            int ac_id = Integer.parseInt(ctx.pathParam("ac_id"));
            int ac_id1 = Integer.parseInt(ctx.pathParam("ac_id1"));
            int amount = Integer.parseInt(ctx.pathParam("amount"));
            ctx.header("Location", String.valueOf(new URI("http://localhost:8081/accounts/" + ac_id+ac_id1+amount)));

            accountService.updateTransfer(ac_id,ac_id1,amount);
            ctx.result("Amount Transferred Successfully");
            ctx.status(204);
        });

        app.delete("/accounts/{id}", (ctx) -> {
            int id = Integer.parseInt(ctx.pathParam("id"));

            accountService.deleteAccount(id);

            ctx.status(200);
        });
       /* app.get("/transactions", (ctx) -> {
            ctx.contentType("application/json");
            ctx.json(accountService.getAllTransactions());
        });*/
       /* app.get("/transactions/{ac_id}", (ctx) -> {
            int ac_id = Integer.parseInt(ctx.pathParam("ac_id"));
            ctx.header("Location", String.valueOf(new URI("http://localhost:8081/transactions/" + ac_id)));
            accountService.getTransactionById(ac_id);


                ctx.status(200);
                ctx.contentType("application/json");
                ctx.json(accountService.getTransactionById(ac_id));



           // ctx.status(404);
            //ctx.result("Account not found");

        });
*/

    }
}