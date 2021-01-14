package com.chobo.book.springboot.config.auth;

import com.chobo.book.springboot.domain.user.Role;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security 설정들을 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
        .and()
        .authorizeRequests().antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
        .antMatchers("/api/v1/**").hasRole(Role.USER.name()).anyRequest().authenticated()
        .and()
        .logout().logoutSuccessUrl("/") //로그아웃 성공시 / 주소로 이동
        .and()
        .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);


    }
}
