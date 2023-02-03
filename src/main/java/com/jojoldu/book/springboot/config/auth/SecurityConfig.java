package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity              //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()     //h2-console 화면을 사용하기 위해 해당 옵션들을 disable한다
                .and()
                    .authorizeRequests()                //URL별 권한 관리 설정하는 옵션의 시작점
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    //권한 관리 대상 지정. "/api/v1/**"주소의 API는 USER권한 가진 사람만 가능
                    .anyRequest().authenticated()       //나머지 URL은 모든 인증된 사용자(로그인한 사용자)에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")          //로그아웃 성공시 "/"로 이동
                .and()
                    .oauth2Login()                      //로그인 기능 설정 진입점
                        .userInfoEndpoint()             //로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                            .userService(customOAuth2UserService);      //userService가 소셜 로그인 성공 시 후속 조치 진행
    }
}
