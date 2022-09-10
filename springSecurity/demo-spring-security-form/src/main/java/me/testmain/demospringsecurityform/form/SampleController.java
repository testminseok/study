package me.testmain.demospringsecurityform.form;

import me.testmain.demospringsecurityform.common.SecurityLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.concurrent.Callable;

@Controller
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /*
    * Principal 의 구현체를 Spring Security 가 현재 인증된 사용자라면 그 정보를 담아
    * Spring MVC Handler 에 받아서 사용할 수 있게 값을 넘겨준다.
    * */
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello, " + principal.getName());
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
