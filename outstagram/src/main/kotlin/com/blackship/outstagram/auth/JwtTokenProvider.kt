package com.blackship.outstagram.auth

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.Authentication
import java.util.*

class JwtTokenProvider(
    private val jwtSecret: String
): AuthenticationTokenProvider {

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
