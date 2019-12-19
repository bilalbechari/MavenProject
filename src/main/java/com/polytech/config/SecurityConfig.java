package com.polytech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
//                .withUser("bilal")
//                .roles("ADMIN")
//                .password(passwordEncoder.encode("password"))
//                .and().withUser("valere")
//                .roles("GUEST")
//                .password(passwordEncoder.encode("valere"));

        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);
        // Créé une table users(username,password,enabled) et une table authorities(username,authority)
        //Il faut que le user ai une authority pour que ca marche
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("", "/about", "/contact").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST,"/stories").authenticated()
                .mvcMatchers(HttpMethod.GET,"/stories").permitAll()
                .anyRequest().authenticated()
//        .and().formLogin().loginPage("/login").successForwardUrl("/home")
        .and().formLogin().successHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(200))
                        .failureHandler((httpServletRequest, httpServletResponse, e) -> httpServletResponse.setStatus(401))
        .and().logout().logoutSuccessUrl("/")
        .and().csrf().disable(); // A enlever ensuite
    }
}
