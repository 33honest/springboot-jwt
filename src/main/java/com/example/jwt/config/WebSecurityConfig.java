package com.example.jwt.config;

import com.example.jwt.security.CustomDaoAuthenticationProvider;
import com.example.jwt.security.JWTAuthenticationFilter;
import com.example.jwt.security.JWTLoginFilter;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Nathan.Liu on 2020/5/11.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public UserDetailsService userService() {
        return new UserService();
    }

    /**
     * 认证用户的来源
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("{noop}123")
                //配置类中权限不需要写前缀
                .roles("USER");
        */

//        System.out.println("configure");
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(new CustomAuthenticationProvider());
        CustomDaoAuthenticationProvider customDaoAuthenticationProvider = new CustomDaoAuthenticationProvider();
        customDaoAuthenticationProvider.setUserDetailsService(userService());
        System.out.println(customDaoAuthenticationProvider);

        auth.authenticationProvider(customDaoAuthenticationProvider);
    }

    /**
     * 设置http验证规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure方法-设置http验证规则");
        http.csrf().disable()
                .authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                //权限检查
                .antMatchers("/hello").hasAuthority("AUTH_WRITE")
                //角色检查
                .antMatchers("/world").hasRole("ADMIN")
                //所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                //添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
//                .addFilter(new JWTLoginFilter("/login", authenticationManager()))
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //添加一个过滤器验证其他请求的Token是否合法
//                .addFilter(new JWTAuthenticationFilter());
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
