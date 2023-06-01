package com.demo.example1.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@SuppressWarnings("deprecation")
@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sneha").password("Sneha@12345").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("sneh").password("pass").roles("manager");
		
	}
	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("sne").password("pas").roles("Admin").build());
		return new InMemoryUserDetailsManager(users);
	}*/
	
	
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable(); 
	  //http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	  http.authorizeRequests().antMatchers("/rest/save").hasRole("manager").and().httpBasic(); 
	  }
	  
	  @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	  (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
	 
	/*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
