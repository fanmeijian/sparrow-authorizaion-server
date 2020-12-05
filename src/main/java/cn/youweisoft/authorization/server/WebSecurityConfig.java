package cn.youweisoft.authorization.server;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    PasswordEncoder passwordEncoder;
//
//    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.csrf().disable().authorizeRequests().antMatchers("/oauth", "/oauth/token").permitAll().anyRequest()
//		.authenticated().and().exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//            User.withUsername("user")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build()
//        );
//    }
//}
