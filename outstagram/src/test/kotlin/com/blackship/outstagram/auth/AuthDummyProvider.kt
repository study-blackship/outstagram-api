package com.blackship.outstagram.auth

import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

internal fun getHttpServletRequest() = MockHttpServletRequest()

internal fun getHttpServletResponse() = MockHttpServletResponse()

internal fun getAuthenticationOAuth2User(
    target: OAuth2User = getOAuth2User(),
    userId: Long = 1
) = AuthenticatedOAuth2User(
    target = target,
    userId = userId
)

internal fun getOAuth2User(
    name: String = "name",
    attributes: MutableMap<String, Any> = mutableMapOf()
) = SpyOAuth2User(
    name,
    attributes
)

internal fun getAuthentication(
    principal: OAuth2User = getOAuth2User()
) = SpyAuthentication(
    principal
)

class SpyOAuth2User(
    private val name: String,
    private val attributes: MutableMap<String, Any>,
): OAuth2User {

    override fun getName() = name

    override fun getAttributes() = attributes

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

}

class SpyAuthentication(
    principal: OAuth2User
): Authentication {

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getCredentials(): Any {
        TODO("Not yet implemented")
    }

    override fun getDetails(): Any {
        TODO("Not yet implemented")
    }

    override fun getPrincipal(): Any {return principal}

    override fun isAuthenticated(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        TODO("Not yet implemented")
    }
}
