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

	/*
	* TODO
	* 	현재 attributes 필드는 google 과 naver 의 구분이 되어있지 않아구분 할 수 있는 방법 구상 필요.
	*   네이버는 Map<Strong, Object> attributes.get("response"); 에 사용자 프로필 정보가 들어있음
	*   이대로 Controller 에서 사용하기엔 코드의 개발 용이성이 없어보임
	* */
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
