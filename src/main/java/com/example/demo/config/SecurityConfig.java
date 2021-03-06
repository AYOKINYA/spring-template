package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/posts")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/posts/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/users/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/layouts/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/layouts/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/basic/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/behavior/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/behavior/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/setting/**")
                .permitAll()
                .antMatchers("/websocket")
                .permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/v3/api-docs", //Swagger3
                        "/swagger-ui/**", //Swagger3
                        "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);

    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


}