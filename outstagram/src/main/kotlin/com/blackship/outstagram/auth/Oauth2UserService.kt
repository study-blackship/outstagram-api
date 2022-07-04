package com.blackship.outstagram.auth

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
class Oauth2UserService(
    private val defaultOAuth2UserService: DefaultOAuth2UserService = DefaultOAuth2UserService(),
    private val userServiceClient: UserServiceClient
): OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest): AuthenticatedOAuth2User {
        val oAuth2User = defaultOAuth2UserService.loadUser(userRequest)
        val userDto = userServiceClient.getUserBy(userRequest.clientRegistration.clientName, oAuth2User.name) ?: userServiceClient.registerUser(
            AuthUserDto(
                resourceServerId = oAuth2User.name,
                resourceServerName = userRequest.clientRegistration.clientName,
                email = oAuth2User.getAttribute<String>("email")!!,
                profileImage = oAuth2User.getAttribute<String>("picture")!!
            )
        )

        return AuthenticatedOAuth2User(target = oAuth2User, userId = userDto.id!!)
    }

}
