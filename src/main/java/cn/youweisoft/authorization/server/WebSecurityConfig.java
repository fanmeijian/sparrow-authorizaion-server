package cn.youweisoft.authorization.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	


//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}

//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//	
//
//    PasswordEncoder passwordEncoder;
//
//    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.oauth2Login(oauth2Login->
//    	oauth2Login.userInfoEndpoint()
//    	);
//    }
	
//	@Bean
//	public ClientDetailsService clientDetailsService() {
//		return new MyClientDetailsService();
//	}
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new MyUserDetailsService();
//    }
}
