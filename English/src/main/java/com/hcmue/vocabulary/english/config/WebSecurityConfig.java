package com.hcmue.vocabulary.english.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcmue.vocabulary.english.services.AccountServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new AccountServices();
    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder  bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
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
        
        // account admin/admin2022
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin")
     				.password("$2a$10$durSlu.dBqqMs1xMSE2Nn.09vcLBPYbD6/Q8OWScmkOMhh1sRX30q").roles("ADMIN");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//all request
//		http.authorizeRequests().anyRequest().permitAll();
		
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')");
		
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
		
		http.authorizeRequests().antMatchers("/static/**").permitAll();
		
		//Admin
		http.authorizeRequests()
    	.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.usernameParameter("username")
			.passwordParameter("password")
			.failureUrl("/login_error")
	        .defaultSuccessUrl("/processHome")
    	.permitAll()
        .and()
        .logout()
        	.logoutSuccessUrl("/").permitAll();
	}
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
