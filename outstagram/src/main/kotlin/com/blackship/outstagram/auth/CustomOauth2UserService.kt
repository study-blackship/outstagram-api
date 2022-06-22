package com.blackship.outstagram.auth

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
class CustomOauth2UserService(
    private val defaultOAuth2UserService: DefaultOAuth2UserService = DefaultOAuth2UserService()
) : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User? {
        defaultOAuth2UserService.loadUser(userRequest)
        return null
    }

}