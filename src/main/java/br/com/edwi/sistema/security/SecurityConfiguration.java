package br.com.edwi.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("oficial")
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/produtos/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/produtos/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/produtos/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/produtos/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/categorias/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/categorias/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/categorias/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/categorias/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/clientes/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/clientes/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/clientes/**").hasAuthority("ADMIN")
                .antMatchers("/pedidos/**").permitAll()
                .antMatchers("/pedido-itens/**").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}