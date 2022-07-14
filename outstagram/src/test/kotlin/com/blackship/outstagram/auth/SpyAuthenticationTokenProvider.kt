package com.blackship.outstagram.auth

import org.springframework.security.core.Authentication

class SpyAuthenticationTokenProvider: AuthenticationTokenProvider {

    lateinit var generateTokenArguments: Authentication
    var generateTokenResult = "token"

    override fun generateToken(authentication: Authentication): String {
        generateTokenArguments = authentication
        return generateTokenResult
    }
}
