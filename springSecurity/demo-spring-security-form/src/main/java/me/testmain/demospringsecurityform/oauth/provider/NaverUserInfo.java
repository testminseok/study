package me.testmain.demospringsecurityform.oauth.provider;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {

    private static final String PROVIDER_ID = "id";

    private static final String PROVIDER = "naver";

    private static final String EMAIL = "email";

    private static final String USERNAME = "name";
    private Map<String, Object> attributes;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get(PROVIDER_ID).toString();
    }

    @Override
    public String getProvider() {
        return PROVIDER;
    }

    @Override
    public String getEmail() {
        return attributes.get(EMAIL).toString();
    }

    @Override
    public String getName() {
        return PROVIDER + "_" + getProviderId();
    }
}
