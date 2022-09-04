package me.testmain.demospringsecurityform.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountService accountService;

    /*
     * 인증되어 있지않은 사용자가 "/" 에 요청했을때
     * */
    @Test
    public void index_anonymous() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").with(anonymous()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
     * 인증되어 있지않은 사용자가 "/" 에 요청했을때
     * */
    @Test
    @WithAnonymousUser
    public void index_anonymous_annotation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/" 에 요청했을때
     * */
    @Test
    public void index_user() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").with(user("testmin").roles("USER")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/" 에 요청했을때
     * */
    @Test
    @WithMockUser(username = "testmin", roles = "USER")
    public void index_user_annotation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/admin" 에 요청했을때
     * */
    @Test
    public void admin_user() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin").with(user("testmin").roles("USER")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/admin" 에 요청했을때
     * */
    @Test
    @WithMockUser(username = "testmin", roles = "USER")
    public void admin_user_annotation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/admin" 에 요청했을때
     * */
    @Test
    public void admin_admin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin").with(user("admin").roles("ADMIN")))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
     * 이미 testmin 으로 인증 되어있는 user 가 "/admin" 에 요청했을때
     * */
    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void admin_admin_annotation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    /*
    * 정상적인 정보로 인증을 요청할경우 성공
    * */
    @Test
    @Transactional
    public void login_success() throws Exception {
        String username = "testmin";
        String password = "123123";
        createUser(username, password);

        mockMvc.perform(formLogin().user(username).password(password))
                .andExpect(authenticated());
    }

    /*
    * 잘못된 정보로 인증을 요청하는경우 인증 실패
    * */
    @Test
    @Transactional
    public void login_fail() throws Exception {
        String username = "testmin";
        String password = "123123";
        createUser(username, password);

        mockMvc.perform(formLogin().user(username).password("123344"))
                .andExpect(unauthenticated());
    }

    private Account createUser(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole("USER");
        return accountService.createNew(account);
    }
}