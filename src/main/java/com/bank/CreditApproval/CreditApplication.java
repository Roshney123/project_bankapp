package com.bank.CreditApproval;

import java.util.Date;

/**
 * POM Model for credit application
 */
public class CreditApplication {

public int app_id;
public String user_id;
public Date app_date;
public String app_status;

    public CreditApplication() {
    }

    /**
     * @param app_id application identifier
     * @param user_id user identification
     * @param app_date date applied
     * @param app_status status of application - Success/Declined/Not decided
     */
    public CreditApplication(int app_id, String user_id, Date app_date, String app_status) {
        this.app_id = app_id;
        this.user_id = user_id;
        this.app_date = app_date;
        this.app_status = app_status;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getApp_date() {
        return app_date;
    }

    public void setApp_date(Date app_date) {
        this.app_date = app_date;
    }

    public String getApp_status() {
        return app_status;
    }

    public void setApp_status(String app_status) {
        this.app_status = app_status;
    }

    @Override
    public String toString() {
        return "CreditApplication{" +
                "app_id=" + app_id +
                ", user_id='" + user_id + '\'' +
                ", app_date=" + app_date +
                ", app_status='" + app_status + '\'' +
                '}';
    }
}
//credit applications view-user,employee
//credit checker
//credit approval
//credit status