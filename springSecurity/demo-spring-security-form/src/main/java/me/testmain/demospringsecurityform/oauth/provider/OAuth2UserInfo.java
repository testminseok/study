package me.testmain.demospringsecurityform.oauth.provider;

/**
 * OAuth2를 통해 인증된 OAuth2User 의 데이터 추출 어뎁터 인터페이스
 * @see GoogleUserInfo
 * @see NaverUserInfo
 * @see GithubUserInfo
 * */
public interface OAuth2UserInfo {
    String getProviderId();
    String getRegistrationId();
    String getEmail();
    String getName();
}
