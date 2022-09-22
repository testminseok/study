package me.testmain.demospringsecurityform.oauth.provider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo {

    private static final String PROVIDER_ID = "sub";

    private static final String PROVIDER = "google";

    private static final String EMAIL = "email";
    private Map<String, Object> attributes;
    public GoogleUserInfo(Map<String, Object> attributes) {
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
