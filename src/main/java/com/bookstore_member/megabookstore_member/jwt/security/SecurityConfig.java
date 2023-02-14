package com.bookstore_member.megabookstore_member.jwt.security;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()    // 요청에 대한 권한 설정
                .antMatchers("/","/registry","/login").permitAll()
                        .antMatchers("/admin").hasRole("ADMIN")
                        .antMatchers("/user").hasRole("USER");

        http.formLogin().disable()
                        .httpBasic().disable()
                        .csrf().disable();
        http.oauth2Login();     //oauth2 로그인 설정
        http.rememberMe();      //rememberMe 설정(Remember Me = 세션이 만료되고 웹이 종료된 이후에도 사용자를 기억하는 기능)
        http.httpBasic();


        // LoginFilter
        http.formLogin()
                .loginPage("/api/loginPage")    // 인증 필요시 이동하는 페이지 api
//                .defaultSuccessUrl("/")     // 로그인 성공 후 이동 페이지 api     // 이게 있으면 동작하지 않음.
                .failureUrl("/login?error=true")      //로그인 실패 후 이동 페이지 api
                .usernameParameter("Id")      // 아이디 파라미터명 설정
                .passwordParameter("passwd")      // 패스워드 파라미터명 설정
//                .loginProcessingUrl("/login_proc")       // 로그인 Form Action Url
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler);

        // AuthenticationException, AccessDeniedException
        http.exceptionHandling()
                        .authenticationEntryPoint(new AuthenticationEntryPoint() {
                            @Override
                            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                                response.sendRedirect("/login");
                            }
                        })
                                .accessDeniedHandler(new AccessDeniedHandler() {
                                    @Override
                                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                                        response.sendRedirect("/denied");
                                    }
                                });


        // LogoutFilter
        http.logout()
                .logoutUrl("/logoutPage")
                .logoutSuccessUrl("/loginPage")
                .deleteCookies("ID", "remember - me")    //로그아웃 후 해당 쿠키 삭제
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
                        HttpSession session = request.getSession();
                        session.invalidate();
                    }
                })
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.sendRedirect("/login");        // 로그아웃 시 로그인 할 수 있는 페이지로 이동
                    }
                })
                .deleteCookies("remember - me");


        // Remember me api 설정
        http.rememberMe()
                .rememberMeParameter("remember")        // remember me 파라미터 설정 api (default = remember - me)
                .tokenValiditySeconds(3600)     // 쿠키 만료 시간 (default = 14일)
                .alwaysRemember(true)
                .userDetailsService(userDetailsService);        // 시스템의 사용자 계정 조회 처리 api


        // 동시 세션 관리
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)     // 추가적인 인증요청 처리 방식 -> true =  현재 사용자 인증 실패, false = 기존 세션 만료
                .expiredUrl("/expired");


        return http.build();
    }

    //로그인 요청 시 인증 처리 담당
    //customAuthenticationProvider 에서 회원정보 찾고 검증
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
      auth.authenticationProvider(customAuthenticationProvider);
    }


}

