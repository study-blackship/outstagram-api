package com.blackship.outstagram.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import java.util.*

class JwtTokenProvider: AuthenticationTokenProvider {

    @Value("#{jwt.secret}")
    private lateinit var jwtSecret: String

    override fun generateToken(authentication: Authentication): String {
        val authenticatedOAuth2User = authentication.principal as AuthenticatedOAuth2User
        return Jwts.builder()
                .setSubject(authenticatedOAuth2User.userId.toString())
                .addClaims(
                    mutableMapOf("email" to authenticatedOAuth2User.getAttribute("email"))
                )
                .setIssuedAt(Date())
                .setExpiration(Date())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }
}
