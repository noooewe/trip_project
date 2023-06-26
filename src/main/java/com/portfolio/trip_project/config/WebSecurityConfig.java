package com.portfolio.trip_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 첫 잠금 해제
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //.csrf().disable()// 나중에 없애기
          http  .authorizeRequests()
                .antMatchers("/", "/createMemberForm", "/login", "/errorPage", "/index").permitAll()
                .antMatchers("/editMember").hasRole("ADMIN")
                .anyRequest().authenticated()

                //로그인
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()

                //로그아웃
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
        ;
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
    }

}



