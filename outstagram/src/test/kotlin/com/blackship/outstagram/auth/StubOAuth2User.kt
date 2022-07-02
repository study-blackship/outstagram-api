package com.blackship.outstagram.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

class StubOAuth2User: OAuth2User {

    override fun getName(): String {
        return "name"
    }

    override fun getAttributes(): MutableMap<String, Any> {
        return mutableMapOf(
            "email" to "email",
            "picture" to "profileImage"
        )
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }
}
