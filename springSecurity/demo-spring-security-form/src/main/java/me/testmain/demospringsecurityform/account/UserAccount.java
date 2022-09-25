package me.testmain.demospringsecurityform.account;

import me.testmain.demospringsecurityform.oauth.provider.OAuth2UserInfo;
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

	private OAuth2UserInfo oAuth2UserInfo;

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
	public UserAccount(Account account, OAuth2UserInfo oAuth2UserInfo) {
		super(account.getUsername(), account.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_" + account.getRole())));
		this.account = account;
		this.oAuth2UserInfo = oAuth2UserInfo;
	}

	@Override
	public String getName() {
		return this.getUsername();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return oAuth2UserInfo.getAttributes();
	}

	public Account getAccount() {
		return account;
	}
}
