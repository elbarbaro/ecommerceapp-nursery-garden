package com.nurserygarden.ecommerceapp.config;

import com.nurserygarden.ecommerceapp.exceptions.CustomAccesDeniedHandler;
import com.nurserygarden.ecommerceapp.exceptions.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private CustomAuthenticationEntryPoint authenticationEntryPoint;
    private CustomAccesDeniedHandler accesDeniedHandler;

    public SecurityConfiguration(UserDetailsService userDetailsService, CustomAccesDeniedHandler accesDeniedHandler, CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.accesDeniedHandler = accesDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }*/

   /* @Bean
    public AuthenticationManager authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authProvider);
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITE_lIST).permitAll() // Exclude login and token endpoints from authentication
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accesDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] WHITE_lIST = {"/token", "/users"};


}

