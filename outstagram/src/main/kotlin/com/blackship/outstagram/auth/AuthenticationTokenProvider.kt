package com.blackship.outstagram.auth

import org.springframework.security.core.Authentication

interface AuthenticationTokenProvider {

    fun generateToken(authentication: Authentication): String

}
