# SpringSecurity Architecture

Spring Security 는 SecurityFilterChain API 를 사용하여 FilterChainProxy 에 각종 필터를 삽입한다.
Spring Security 에서 제공하는 Filter 는 다음과 같은 순서를 가진다.

- ForceEagerSessionCreationFilter
- ChannelProcessingFilter
- WebAsyncManagerIntegrationFilter
- [SecurityContextPersistenceFilter](#securitycontextpersistencefilter)
- HeaderWriterFilter
- CorsFilter
- CsrfFilter
- LogoutFilter
- OAuth2AuthorizationRequestRedirectFilter
- Saml2WebSsoAuthenticationRequestFilter
- X509AuthenticationFilter
- AbstractPreAuthenticatedProcessingFilter
- CasAuthenticationFilter
- OAuth2LoginAuthenticationFilter
- Saml2WebSsoAuthenticationFilter
- [UsernamePasswordAuthenticationFilter](#usernamepasswordauthenticationfilter)
- OpenIDAuthenticationFilter
- [DefaultLoginPageGeneratingFilter](#defaultloginpagegeneratingfilter)
- [DefaultLogoutPageGeneratingFilter](#defaultlogoutpagegeneratingfilter)
- ConcurrentSessionFilter
- DigestAuthenticationFilter
- BearerTokenAuthenticationFilter
- BasicAuthenticationFilter
- RequestCacheAwareFilter
- SecurityContextHolderAwareRequestFilter
- JaasApiIntegrationFilter
- RememberMeAuthenticationFilter
- AnonymousAuthenticationFilter
- OAuth2AuthorizationCodeGrantFilter
- SessionManagementFilter
- ExceptionTranslationFilter
- [FilterSecurityInterceptor](#filtersecurityinterceptor)
- [AuthorizationFilter](#authorizationfilter) (FilterSecurityInterceptor 를 대체 한다.)
- SwitchUserFilter

___
## SecurityContextPersistenceFilter
SecurityContextPersistenceFilter 는 HttpSession 을 통해 저장되어 있는 SecurityContext 를 조회하여
SecurityContextHolder 에 저장한다. 이때, SecurityContext 에는 사용자의 인증 정보를 담고 있는 Authentication 객체를 가지고 있다.
또한, 요청이 완료되어 쓰레드가 종료될때 SecurityContext 를 SecurityContextHolder 에서 삭제한다.
그 이유는 SecurityContext 는 ThreadLocal 을 사용하여 객체를 저장하는데, 
TheadPool 을 사용하여 Thread 를 재사용할때 dummy 데이터가 들어 있을 수 있기 때문이다.

## UsernamePasswordAuthenticationFilter
UsernamePasswordAuthenticationFilter 는 form 을 통한 인증을 진행할때 인증을 담당하는 Filter 이다.
AbstractAuthenticationProcessingFilter 를 상속받고 있으며, `attemptAuthentication(request, response)` 를 오버라이딩 하였다.
인증을 진행할때에는 AuthenticationManager 을 통해 인증을 진행하는데, 대부분의 경우 AuthenticationManager 를 상속받은 
ProviderManager 가 인증을 담당하여 진행한다.
ProviderManager 는 등록된 providers 중에 해당 Authentication 객체 여기서는 (UsernamePasswordAuthenticationToken) 를
처리 할 수 있는 provider 를 찾아 인증을 진행 하고 Authentication 객체를 반환한다.
> 보통은 UserDetailsService 를 @Bean 으로 등록하여 DB 에서 사용자를 조회한다.
> 여기서 조회된 UserDetails 가 Principal 객체이다. 

## DefaultLoginPageGeneratingFilter
DefaultLoginPageGeneratingFilter 는 Custom 로그인 페이지를 등록하지 않았을때 SpringSecurity 에서 기본으로 제공하는 로그인 
페이지를 사용하기 위한 Filter 이다. Custom 한 로그인페이지를 등록하면 해당 필터는 SecurityFilterChain 에서 제외된다.

## DefaultLogoutPageGeneratingFilter
DefaultLogoutPageGeneratingFilter 는 Custom 로그아웃 페이지를 등록하지 않았을때 SpringSecurity 에서 기본으로 제공하는 로그아웃
페이지를 사용하기 위한 Filter 이다. Custom 한 로그인 페이지를 등록해도 해당 필터는 SecurityFilterChain 에서 제외된다.

## ExceptionTranslationFilter
AuthorizationFilter 또는 FilterSecurityInterceptor 에서 AuthenticationException 과 
AccessDeniedException 가 발생했을때 처리를한다.
AuthenticationException 는 AuthenticationEntryPoint 를 사용하여 인증이 가능한 페이지로 이동시킨다.
AccessDeniedException 는 AccessDeniedHandler 를 사용하여 처리를 담당한다. (403 error 페이지)

## FilterSecurityInterceptor
FilterSecurityInterceptor 는 인가를 담당하는 Filter 이다
인증이 되지 않았을땐 AuthenticationException 을
권한이 없는 resource 에 접근하려 할땐 AccessDeniedException 을 발생시킨다.
AccessDecisionManager 를 통해 권한이 있는지 없는지를 판단한다.
AccessDecisionManager 는 AffirmativeBased 를 기본으로 사용하고,
AccessDecisionVoter 가 하나라도 동의 한다면 해당 Resource 에 접근할 수 있는 권한을 부여한다.
하지만, 모두 동의하지 않는다면 AccessDeniedException 를 발생시킨다.

## AuthorizationFilter
FilterSecurityInterceptor 와 역활은 동일하지만 AccessDecisionManager 를 사용하지 않는다.
Authentication 에 담겨있는 권한을 확인한다. 현재 5.7.3 버전 에서는 AuthorizationFilter 는 
AccessDecisionManager 를 통한 권한 계층을 설정하는것이 불가능하다.