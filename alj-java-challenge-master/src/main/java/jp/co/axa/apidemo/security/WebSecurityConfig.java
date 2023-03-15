package jp.co.axa.apidemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Define users for this application. Admin and User.
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").authorities("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").authorities("EMPLOYEE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Permissions for endpoints are defined here based on roles
        http.authorizeRequests()

                .antMatchers( "/api/v1/departments").authenticated()

                // Restrict usage of Post, Delete and Put methods to ADMIN
                .antMatchers(HttpMethod.POST,"/api/v1/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/v1/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v1/**").hasAuthority("ADMIN")

                .anyRequest().authenticated()

                // Define LoginForm. This case it will use the default one
                .and()
                .formLogin();

        // Disable some security features to allow requests in this development environment
        http.csrf().disable();
        http.cors().disable();

        // This needs to be disabled so the H2 Console works
        http.headers().frameOptions().disable();
;
    }

}