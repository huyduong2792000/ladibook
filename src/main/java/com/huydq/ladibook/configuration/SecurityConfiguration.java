package com.huydq.ladibook.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.huydq.ladibook.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("admin")
				.anyRequest().permitAll().and().exceptionHandling().accessDeniedPage("/logout");

		http.formLogin().loginPage("/logout").loginProcessingUrl("/login").usernameParameter("email")
				.passwordParameter("password").defaultSuccessUrl("/admin/home")
				.failureUrl("/login?err=Looks like either your account. Wanna try again?").permitAll();
		http.logout().logoutSuccessUrl("/login").permitAll();

	}

}
