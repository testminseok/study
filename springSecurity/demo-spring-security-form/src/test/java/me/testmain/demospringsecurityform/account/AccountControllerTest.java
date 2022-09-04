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

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

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
}