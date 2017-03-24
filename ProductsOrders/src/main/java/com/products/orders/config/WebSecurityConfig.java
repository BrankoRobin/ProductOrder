package com.products.orders.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated()
		.and()
		.authorizeRequests().antMatchers("/", "/orders")
				.permitAll().anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/", false)
				.failureUrl("/login?error").permitAll()
				.and().logout()
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("blue").password("blue").roles("USER")
		.and().withUser("red")
				.password("red").roles("USER");
	}
}
