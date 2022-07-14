package com.blackship.outstagram.auth

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Oauth2SuccessHandler(
    private val tokenProvider: AuthenticationTokenProvider
): AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val token = tokenProvider.generateToken(authentication)
        val cookie = Cookie("AUTH", token)
        response.addCookie(cookie)
    }

}
