package com.bank.CommonUser;

import java.net.URI;

public interface UserService {
    User authenticate(String username, String password) throws UserNotFoundException,IllegalStateException;//login authentication


//deposit money// no negative value can deposit
//withdraw money //check balance is 0 or less -get the bank account details, check the balance , if enough money withdraw money and update balance
    //view transaction history,
    // apply for credit,
    // view credit approval or decline

    //No need to delete an account, because bank always keep records even the account is closed
       /* app.delete("/accounts/{id}",(ctx->{
            int id= Integer.parseInt(ctx.pathParam("id"));
            accountService.deleteAccount(id);
            ctx.status(200);

        }));*/
}

