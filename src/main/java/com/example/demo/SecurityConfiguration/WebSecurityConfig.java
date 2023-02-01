package com.example.demo.SecurityConfiguration;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    public UserDetailsServiceImpl userDetailsServiceImpl(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
				 "/signup**",
	                "/js/**",
	                "/css/**",
	                "/img/**").permitAll()
            .antMatchers("/").hasAnyAuthority("student", "PROFESSOR", "RESPONSIBLE", "ADMIN")
            .antMatchers("/admin").hasAnyAuthority("ADMIN")
            .antMatchers("/responsible/**").hasAnyAuthority("RESPONSIBLE")
            .antMatchers("/professor/**").hasAuthority("PROFESSOR")
            .antMatchers("/student/**").hasAuthority("student")
            .anyRequest().authenticated()
            .and()
            .formLogin()
    		.loginPage("/signin")
    		.permitAll()
            .and().csrf().disable()
            .logout().invalidateHttpSession(true)
    		.clearAuthentication(true)
    		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    		.logoutSuccessUrl("/signin?logout")
    		.permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403");
    }
}
