# SpringSecurity Architecture

Spring Security 는 SecurityFilterChain API 를 사용하여 FilterChainProxy 에 각종 필터를 삽입한다.
Spring Security 에서 제공하는 Filter 는 다음과 같은 순서를 가진다.

- ForceEagerSessionCreationFilter
- ChannelProcessingFilter
- WebAsyncManagerIntegrationFilter
- [SecurityContextPersistenceFilter](#securitycontextpersistencefilter)
- HeaderWriterFilter
- [CorsFilter](#corsfilter)
- [CsrfFilter](#csrffilter)
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
- [BearerTokenAuthenticationFilter](#bearertokenauthenticationfilter)
- [BasicAuthenticationFilter](#basicauthenticationfilter)
- RequestCacheAwareFilter
- SecurityContextHolderAwareRequestFilter
- JaasApiIntegrationFilter
- RememberMeAuthenticationFilter
- AnonymousAuthenticationFilter
- OAuth2AuthorizationCodeGrantFilter
- SessionManagementFilter
- [ExceptionTranslationFilter](#exceptiontranslationfilter)
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

## CorsFilter
CorsFilter 는 Cross-Origin Resource Sharing (CORS) 를 지원하기 위한 필터이다.
CORS 는 웹 애플리케이션에서 다른 도메인의 리소스에 접근할 수 있도록 하는 규약이며, 
CORS 를 지원하기 위해서는 서버에서 Access-Control-Allow-Origin 헤더를 응답에 포함시켜야 한다.
이때, CorsFilter 는 Access-Control-Allow-Origin 헤더를 응답에 포함시키는 역할을 한다.

브라우저에서는 다른 도메인의 리소스에 접근을 시도할 경우 preflight request 를 OPTIONS 메서드로 요청한다.
서버에서 Access-Control-Allow-Origin 헤더를 포함한 응답을 받으면 응답 헤더를 확인하여 실제 요청 또는 CORS 에러를 반환한다.
이때 실제 요청은 GET, POST, PUT, DELETE 등의 메서드로 요청을 보낸다.
> CORS 는 브라우저에서 동작하는 보안 규약이므로 서버에서는 CORS 를 지원하기 위한 설정만 하면 된다.

## CsrfFilter
CsrfFilter 는 Cross-Site Request Forgery (CSRF) 공격을 방어하기 위한 필터이다.
CSRF 공격은 사용자가 자신의 의지와는 무관하게 공격자가 의도한 행위를 하도록 만드는 공격이다.
CSRF 공격을 방어하기 위해서는 서버에서는 CSRF 토큰을 생성하여 응답에 포함시켜야 한다.
이때, CSRF 토큰은 쿠키에 저장되어야 한다.
클라이언트에서는 CSRF 토큰을 쿠키에서 읽어서 요청에 포함시켜야 한다.
그리고, 서버에서는 요청에 포함된 CSRF 토큰과 쿠키에 저장된 CSRF 토큰이 일치하는지 확인해야 한다.

> SpringSecurity 에서는 CSRF 토큰 생성을 위해 CsrfTokenRepository 를 사용한다. 
> CsrfTokenRepository 는 CsrfToken 을 생성하고 저장하는 역활을 하며 HttpSessionCsrfTokenRepository 를 기본 구현체로 사용한다.
> HttpSessionCsrfTokenRepository 는 HttpSession 을 사용하여 CsrfToken 을 저장하며 요청 헤더에 CsrfToken 과 HttpSession 에 
> 저장된 CsrfToken 을 비교하여 CSRF 공격을 방어한다.

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

## BearerTokenAuthenticationFilter
BearerTokenAuthenticationFilter 는 HttpHeader 에 Authorization Type 이 Bearer 인것에 대한 인증을 담당한다.
인증서버에서 인증 수단을 Token(JWT or OpaqueToken) 을 사용할 경우 이 Token 을 HttpHeader 에 Authorization : Bearer "myToken" 과 같이 요청하고, 
해당 토큰을 인증서버에서 검증한 뒤 Authentication 객체를 SecurityContext 에 등록한다.
해당 필터는 spring-boot-starter-oauth2-resource-server 를 dependency 하면 사용할 수 있다. 
또한, JWT 의 경우 사용자 정보가 세션에 있지 않고 Token 자체에 있기 때문에 서버의 Session 을 StateLess 하게 유지 할 수 있다.
때문에 서버에 대한 부하가 줄어들고 다른 웹서비스에 전달이 가능하므로 확장성이 높아진다.
> JWT 를 사용할 경우 http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); 으로 SecurityFilterChain 에 등록할 수 있다.

## BasicAuthenticationFilter
BasicAuthenticationFilter 또한 인증을 진행할 수 있는 방법 중 하나인데, HttpHeader 에 Authorization Type 이 Basic 인것에 대한 인증을 담당한다.
HttpHeader 에 Authorization : Basic Base64.encode("{myId:myPassword}") 와 같이 아이디와 비밀번호를 형식({id:password})에 맞춰 
Base64 로 인코딩 한 후 인증서버에 인증을 요청하면 해당 서버는 고객정보를 확인하여 접근을 허가한다.
> Basic 방식의 인증은 고객의 아이디 와 비밀번호가 포함되어 있으므로, 탈취 될경우 보안상 큰 이슈가 발생하기 떄문에, HTTPS 를 사용하는것은 필연적이다.

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
인증이 되지 않았을땐 AuthenticationException 을
권한이 없는 resource 에 접근하려 할땐 AccessDeniedException 을 발생시킨다. 
> 5.7.3 버전 에서는 FilterSecurityInterceptor 대신 AuthorizationFilter 를 사용하는것으로 변경 되었으며,
> AccessDecisionManager 를 통한 권한 계층을 설정하는것이 불가능하다. 향후 FilterSecurityInterceptor 를 AuthorizationFilter 로
> 완전히 대체 하게 변경 되고 있다.