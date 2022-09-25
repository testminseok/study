package me.testmain.demospringsecurityform.oauth.provider;

import java.util.Map;

/**
 * OAuth2 인증 된 OAuth2User 객체의 Naver 사용자 데이터 추출 클래스
 * */
public class NaverUserInfo implements OAuth2UserInfo {

    public static final String REGISTRATION_ID = "naver";

    private static final String PROVIDER_ID = "id";

    private static final String EMAIL = "email";

    private Map<String, Object> attributes;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return attributes.get(PROVIDER_ID).toString();
    }

    @Override
    public String getRegistrationId() {
        return REGISTRATION_ID;
    }

    @Override
    public String getEmail() {
        return attributes.get(EMAIL).toString();
    }

    @Override
    public String getName() {
        return REGISTRATION_ID + "_" + getProviderId();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
