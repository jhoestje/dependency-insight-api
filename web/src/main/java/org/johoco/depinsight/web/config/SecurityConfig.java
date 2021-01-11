package org.johoco.depinsight.web.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig { //extends WebSecurityConfigurerAdapter {
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
////				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
////	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//
//	}
//
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
