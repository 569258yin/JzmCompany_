package com.jinzhimu.company.config;

import com.jinzhimu.company.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by MyPC on 2017/6/13.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .anyRequest().authenticated()  //对所有请求都需要验证权限.hasRole("ADMIN")
                .antMatchers("/templates/admin/**","/admin/index").anonymous()
                .antMatchers("/templates/public/**","/").anonymous()
                .and()
                .formLogin().loginPage("/login")
                //设置默认登录成功跳转页面
                .defaultSuccessUrl("/templates/admin/index").failureUrl("/login?error").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("1f463as16dsgdf361h65d4")
                .and()
                .logout()
                //默认注销行为为logout，可以通过下面的方式来修改
                .logoutUrl("/logout")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                .logoutSuccessUrl("/index")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
