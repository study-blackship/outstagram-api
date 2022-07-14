package com.blackship.outstagram.auth

import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
class SecurityConfig(
    private val oauth2UserService: Oauth2UserService,
    private val environment: Environment
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(oauth2UserService)
                .and()
                .successHandler(Oauth2SuccessHandler(JwtTokenProvider(environment.getProperty("jwt.secret")!!)))
    }
}
