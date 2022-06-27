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

    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User? {
        // resourceserver에서 사용자 정보를 받았을 때 해당 사용자의 회원가입 여부를 판단함
        // oauth사용자를 가져와서
        // 가져온 oauth사용자데이터를 가지고 사용자 서비스에서 사용자를 조회 crc card <-
        // 만약 존재하지 않는다면 사용자 서비스에 사용자 추가 요청
        // 가져온 사용자를 갖고 Oauth2User <- 구현한 저희만의 Oauth2User객체를 만드는것도 좋을것같아요
        return null
    }

}
