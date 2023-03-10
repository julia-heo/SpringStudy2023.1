package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)                         //스프링 부트 테스트와 JUnit 사이의 연결자 역할
//@WebMvcTest(controllers = HelloController.class )    //컨트롤러 쓰려고 선언
//WebMvcTest는  CustomOAuth2UserService 스캔x
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {  //스캔대상에서 SecurityConfig 제거. 언제 삭제될지 모르니까 사용x
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {

    @Autowired                                       //빈Bean 주입받음
    private MockMvc mvc;                             //웹API 테스트에 사용

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))          //MockMvc로 /hello주소로 HTTP Get 요청
                .andExpect(status().isOk())            //결과 검증: 200인지
                .andExpect(content().string(hello));   //결과 검증: Controller에서 "hello'리턴하는지
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
