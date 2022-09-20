package me.testmain.demospringsecurityform.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println("userRequest: " + userRequest);
        System.out.println("userRequest getClientRegistration: " + userRequest.getClientRegistration());
        System.out.println("userRequest getAccessToken: " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getAttributes:" + oAuth2User.getAttributes());

        return oAuth2User;
    }
}
