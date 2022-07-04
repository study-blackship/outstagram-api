package com.blackship.outstagram.auth

import com.blackship.outstagram.user.getOAuth2UserRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Oauth2UserServiceTest {

    lateinit var spyUserServiceClient: SpyUserServiceClient
    lateinit var spyDefaultOauth2UserService: SpyDefaultOauth2UserService
    lateinit var oauth2UserService: Oauth2UserService

    @BeforeEach
    internal fun setUp() {
        spyDefaultOauth2UserService = SpyDefaultOauth2UserService()
        spyUserServiceClient = SpyUserServiceClient()
        oauth2UserService = Oauth2UserService(
            spyDefaultOauth2UserService,
            spyUserServiceClient
        )
    }

    @Test
    fun loadUser_get_OAuth2User_by_defaultOauth2UserService() {
        val oAuth2UserRequest = getOAuth2UserRequest()
        oauth2UserService.loadUser(oAuth2UserRequest)
        assertThat(spyDefaultOauth2UserService.loadUserArgumentsUserRequest).isEqualTo(oAuth2UserRequest)
    }

    @Test
    fun loadUser_get_AuthUserDto_by_UserServiceClient() {
        val oAuth2UserRequest = getOAuth2UserRequest()
        oauth2UserService.loadUser(oAuth2UserRequest)
        val oAuth2User = spyDefaultOauth2UserService.loadUserResult
        assertThat(spyUserServiceClient.getUserByArgumentsResourceServerName).isEqualTo(getOAuth2UserRequest().clientRegistration.clientName)
        assertThat(spyUserServiceClient.getUserByArgumentsResourceServerId).isEqualTo(oAuth2User.name)
    }

    @Test
    fun loadUser_register_AuthUserDto_by_UserServiceClient_when_get_AuthUserDto_is_null() {
        val oAuth2UserRequest = getOAuth2UserRequest()
        val oAuth2User = spyDefaultOauth2UserService.loadUserResult
        spyUserServiceClient.getUserByResult = null
        oauth2UserService.loadUser(oAuth2UserRequest)
        assertThat(spyUserServiceClient.registerUserArguments).isEqualTo(
            AuthUserDto(
                resourceServerId = oAuth2User.name,
                resourceServerName = oAuth2UserRequest.clientRegistration.clientName,
                email = oAuth2User.getAttribute<String>("email")!!,
                profileImage = oAuth2User.getAttribute<String>("picture")!!
            )
        )
    }

    @Test
    fun loadUser_not_calls_registerUser_when_get_AuthUserDto_is_not_null() {
        oauth2UserService.loadUser(getOAuth2UserRequest())
        assertThat(spyUserServiceClient.registerUserArguments).isNull()
    }

    @Test
    fun loadUser_returns_OAuth2User() {
        val oAuth2User = oauth2UserService.loadUser(getOAuth2UserRequest())
        val expectedOAuth2User = spyDefaultOauth2UserService.loadUserResult
        assertThat(oAuth2User).isEqualTo(expectedOAuth2User)
    }

}
