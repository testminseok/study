package me.testmain.demospringsecurityform.account;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Arrays;
import java.util.Map;

/*
 * UserDetailsService 에서 return 하기 위한 Account 어댑터 클래스
 * */
public class UserAccount extends User implements OAuth2User {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> attributes;

	private Account account;

	/*
	* form 인증용 생성자
	* */
	public UserAccount(Account account) {
		super(account.getUsername(), account.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
		this.account = account;
	}

	/*
	* OAuth2 인증용 생성자
	* */
	public UserAccount(Account account, Map<String, Object> attributes) {
		super(account.getUsername(), account.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
		this.account = account;
		this.attributes = attributes;
	}

	@Override
	public String getName() {
		return this.getUsername();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public Account getAccount() {
		return account;
	}
}
