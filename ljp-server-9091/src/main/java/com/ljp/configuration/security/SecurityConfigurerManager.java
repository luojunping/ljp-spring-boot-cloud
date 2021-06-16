package com.ljp.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration(proxyBeanMethods = false)
public class SecurityConfigurerManager extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("admin").roles("admin").and().withUser("guest").password("guest").roles("guest");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/*").permitAll().antMatchers("/admin/*").hasRole("admin").antMatchers("/guest/*").access("hasRole('guest')").anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
	}

}
