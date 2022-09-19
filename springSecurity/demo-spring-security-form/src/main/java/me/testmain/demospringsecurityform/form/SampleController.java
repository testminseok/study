package me.testmain.demospringsecurityform.form;

import java.security.Principal;
import java.util.concurrent.Callable;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.testmain.demospringsecurityform.account.Account;
import me.testmain.demospringsecurityform.book.BookRepository;
import me.testmain.demospringsecurityform.common.CurrentUser;
import me.testmain.demospringsecurityform.common.SecurityLogger;

@Controller
public class SampleController {

    private final SampleService sampleService;
    
    private final BookRepository bookRepository;

    public SampleController(SampleService sampleService, BookRepository bookRepository) {
        this.sampleService = sampleService;
		this.bookRepository = bookRepository;
    }

    /*
    * Principal 의 구현체를 Spring Security 가 현재 인증된 사용자라면 그 정보를 담아
    * Spring MVC Handler 에 받아서 사용할 수 있게 값을 넘겨준다.
    * 
    * - UserDetailsService 에서 return 해주는 객체를 @AuthenticationPrincipal 로 가져올 수 있다.
    * public String index(Model model, Principal principal)
    * 	- java 에서 제공하는 Principal 객체를 사용한다.
    * public String index(Model model, @AuthenticationPrincipal UserAccount userAccount)
    * 	- UserDetailsService 에서 return 하는 객체를 사용한다.
    * public String index(Model model, @AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : account") Account account)
    *   - 익명사용자가 아니라면 UserDetailsService 에서 return 하는 객체의 Account Field 를 가져온다.
    * public String index(Model model, @CurrentUser Account account)
    *   - Custom 한 Annotation 을 만들어 간략하게 사용할 수 있다.
    * */
    @GetMapping("/")
    public String index(Model model, @CurrentUser Account account) {
        if (account == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello, " + account.getUsername());
        }

        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Hello Spring Security");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Hello, " + principal.getName());
        sampleService.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "Hello Admin, " + principal.getName());
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("message", "Hello user, " + principal.getName());
        model.addAttribute("books", bookRepository.findCurrentUserBook());
        return "user";
    }

    @GetMapping("async-handler")
    @ResponseBody
    public Callable<String> asyncHandler() {
        /*
        * WebAsyncManagerIntegrationFilter 는
        * 스프링 MVC 의 Async 기능을 사용할 때에도 SecurityContext 를 공유 할 수 있도록 해준다.
        * */
        SecurityLogger.log("MVC");
        return () -> {
            SecurityLogger.log("Callable");
            return "Async Handler";
        };
    }

    @GetMapping("async-service")
    @ResponseBody
    public String asyncService() {
        /*
        * 기본적인 설정으로는 @Async 어노테이션을 메소드에서 사용하여도
        * Async 하게 진행되지만 Main 메소드가 있는 클래스에 @EnableAsync 어노테이션을 붙여주면 Async 하게 동작한다.
        * 하지만 @Async 를 사용하여 다른 쓰레드를 사용할때 SecurityContext 는 공유할 수 없다.
        *
        * SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL); 처럼 설정하여
        * @Async 를 사용한 메소드 내에 파생된 Thread 에서도 SecurityContext 를 공유하게 할 수 있다.
        * */
        SecurityLogger.log("MVC, before async service");
        sampleService.asyncService();
        SecurityLogger.log("MVC, after async service");

        return "Async Handler";
    }
}
