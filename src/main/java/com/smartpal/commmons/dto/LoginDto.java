package com.smartpal.commmons.dto;

import com.smartpal.commmons.bean.LoginBean;

public class LoginDto {
    private String account;
    private String password;

    public LoginDto() {
    }

    public LoginDto(LoginBean loginBean) {
        this.account = loginBean.getAccount();
        this.password = loginBean.getPassword();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
