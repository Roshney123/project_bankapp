package com.bank.CreditApproval;


import com.bank.CommonUser.*;

/**
 * To check the credit score of the user and to determine the credit approval based on credit score
 */
public class CreditChecker {
    //Like if applied amount is less than 50% percent of balance amount and Balance>6000 put excellent
    //If applied amount is between 50% -60% percent of balance amount and 6000>Balance>4000 put Good
   // If applied amount is between 60% -70% percent of balance amount and 4000>Balance>2000 put Poor
    //If applied amount is between 70% -80% percent of balance amount and 2000>Balance put Bad
public String creditscore;
public int amount_applied;

    public CreditChecker() {
    }

    public CreditChecker(String creditscore, int amount_applied) {
        this.creditscore = creditscore;
        this.amount_applied = amount_applied;

        //if(amount_applied<50% (balance)&&(balance > )
    }

}
