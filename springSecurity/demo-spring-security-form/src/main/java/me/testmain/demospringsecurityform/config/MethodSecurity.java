package me.testmain.demospringsecurityform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/*
* Method Security - 매소드에서 권한 확인을 위한 어노테이션을 쓰기위한 config 파일
* 메소드에서 권한을 확일할때 계층권한을 SecurityFilterChain 에 설정하여도 인식하지 못하여
* 별도로 추가해야한다.
* */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class MethodSecurity extends GlobalMethodSecurityConfiguration {
    @Override
    protected AccessDecisionManager accessDecisionManager() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        AffirmativeBased accessDecisionManager = (AffirmativeBased) super.accessDecisionManager();
        accessDecisionManager.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));

        return accessDecisionManager;
    }
}
