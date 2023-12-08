package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.Repository.UserAccountRepository;

import com.example.demo.Service.UserAccountServiceImple;

import jakarta.servlet.http.HttpFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	protected UserAccountServiceImple userAccountService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
					.requestMatchers("/", "/register", "/create", "/auth","/css/**", "/images/**","/admin/postcards").permitAll()
					.requestMatchers("/admin/**").hasRole("admin")
					.anyRequest().authenticated()
					)
//			.userDetailsService(userAccountService)
			.formLogin(formLogin -> formLogin
							.loginPage("/login")
							.loginProcessingUrl("/login")
							.defaultSuccessUrl("/")
							.permitAll()
					)
			.logout((logout) -> logout.permitAll());
		return http.build();
	}
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userAccountService);
//	        	
//	    }

}
