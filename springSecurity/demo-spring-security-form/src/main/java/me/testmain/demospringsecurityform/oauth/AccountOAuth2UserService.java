package me.testmain.demospringsecurityform.oauth;

import me.testmain.demospringsecurityform.account.Account;
import me.testmain.demospringsecurityform.account.AccountService;
import me.testmain.demospringsecurityform.account.UserAccount;
import me.testmain.demospringsecurityform.oauth.provider.GithubUserInfo;
import me.testmain.demospringsecurityform.oauth.provider.GoogleUserInfo;
import me.testmain.demospringsecurityform.oauth.provider.NaverUserInfo;
import me.testmain.demospringsecurityform.oauth.provider.OAuth2UserInfo;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountOAuth2UserService extends DefaultOAuth2UserService {

    private final AccountService accountService;

    public AccountOAuth2UserService(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
    * OAuth2 인증 완료 후 실행되는 함수
    * */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println("ClientRegistration : " + userRequest.getClientRegistration());
        System.out.println("ClientRegistration : " + userRequest.getClientRegistration().getProviderDetails());
        System.out.println("accessToken : " + userRequest.getAccessToken());
        System.out.println("attributes : " + oAuth2User.getAttributes());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserInfo oAuth2UserInfo = oAuth2UserInfo(registrationId, oAuth2User.getAttributes());
        String username = oAuth2UserInfo.getName();

        /*
        * OAuth2 인증 사용자의 경우 비밀번호를 통한 로그인을 진행하지 않기 때문에 비밀번호에 값이 무엇이 들어있든 상관이 없다.
        * */
        Account oAuth2Account = new Account();
        oAuth2Account.setUsername(username);
        oAuth2Account.setPassword(username);
        oAuth2Account.setRole("USER");

        /*
        * 이미 가입된 사용자 인지 확인한다.
        * */
        Account account = accountService.findByUsername(username);

        if (account == null) {
            account = accountService.createNew(oAuth2Account);
        }

        /*
        * OAuth2 인증 사용자와 form 인증 사용자를 같이 사용하기 위한 객체
        * */
        return new UserAccount(account, oAuth2User.getAttributes());
    }

    private OAuth2UserInfo oAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (GoogleUserInfo.REGISTRATION_ID.equals(registrationId)) {
            System.out.println("구글 로그인 요청");
            return new GoogleUserInfo(attributes);
        } else if (NaverUserInfo.REGISTRATION_ID.equals(registrationId)) {
            System.out.println("네이버 로그인 요청");
            return new NaverUserInfo(attributes);
        } else if (GithubUserInfo.REGISTRATION_ID.equals(registrationId)) {
            System.out.println("깃허브 로그인");
            return new GithubUserInfo(attributes);
        }

        throw new OAuth2AuthenticationException("is not support login type");
    }
}
