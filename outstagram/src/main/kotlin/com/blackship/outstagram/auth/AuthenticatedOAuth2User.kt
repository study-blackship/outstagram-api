package com.blackship.outstagram.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

class AuthenticatedOAuth2User(
    private val target: OAuth2User,
    val userId: Long
): OAuth2User {

    override fun getName(): String = target.name

    override fun getAttributes(): MutableMap<String, Any> = target.attributes

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = target.authorities

}
