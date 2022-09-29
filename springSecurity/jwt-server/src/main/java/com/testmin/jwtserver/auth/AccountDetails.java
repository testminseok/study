package com.testmin.jwtserver.auth;

import com.testmin.jwtserver.model.Account;
import org.springframework.security.core.userdetails.User;

public class AccountDetails extends User {
    private Account account;

    public AccountDetails(Account account) {
        super(account.getUsername(), account.getPassword(), account.getRoles());
        this.account = account;
    }
}
