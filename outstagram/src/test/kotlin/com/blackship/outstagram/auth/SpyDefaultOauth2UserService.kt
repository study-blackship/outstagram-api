package com.blackship.outstagram.auth

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User

class SpyDefaultOauth2UserService: DefaultOAuth2UserService() {

    var loadUserArgumentsUserRequest: OAuth2UserRequest? = null
    var loadUserResult: OAuth2User = StubOAuth2User()

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        loadUserArgumentsUserRequest = userRequest
        return loadUserResult
    }

}
