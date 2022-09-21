package me.testmain.demospringsecurityform.config.oauth;

import me.testmain.demospringsecurityform.account.Account;
import me.testmain.demospringsecurityform.account.AccountRepository;
import me.testmain.demospringsecurityform.account.UserAccount;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public PrincipalOAuth2UserService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*
    * OAuth2 인증 완료 후 실행되는 함수
    * */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getRegistrationId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = provider + "_" + providerId;

        /*
        * OAuth2 인증 사용자의 경우 비밀번호를 통한 로그인을 진행하지 않기 때문에 비밀번호에 값이 무엇이 들어있든 상관이 없다.
        * */
        Account oAuth2Account = new Account();
        oAuth2Account.setUsername(username);
        oAuth2Account.setPassword(username);
        oAuth2Account.setRole("USER");
        oAuth2Account.setEncodePassword(passwordEncoder);

        /*
        * 이미 가입된 사용자 인지 확인한다.
        * */
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            account = accountRepository.save(oAuth2Account);
        }

        /*
        * OAuth2 인증 사용자와 form 인증 사용자를 같이 사용하기 위한 객체
        * */
        return new UserAccount(account, oAuth2User.getAttributes());
    }
}
