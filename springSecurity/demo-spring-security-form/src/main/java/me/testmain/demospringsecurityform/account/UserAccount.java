package me.testmain.demospringsecurityform.account;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/*
 * UserDetailsSevice 에서 return 하기 위한 Account 어댑터 클래스
 * */
public class UserAccount extends User {

	private static final long serialVersionUID = 1L;

	private Account account;

	public UserAccount(Account account) {
		super(account.getUsername(), account.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

}
