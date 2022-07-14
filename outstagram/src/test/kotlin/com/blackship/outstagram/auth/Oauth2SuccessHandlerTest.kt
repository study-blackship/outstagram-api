package com.blackship.outstagram.auth

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Oauth2SuccessHandlerTest {

    private lateinit var oauth2SuccessHandler: Oauth2SuccessHandler
    private lateinit var spyAuthenticationTokenProvider: SpyAuthenticationTokenProvider

    @BeforeEach
    internal fun setUp() {
        spyAuthenticationTokenProvider = SpyAuthenticationTokenProvider()
        oauth2SuccessHandler = Oauth2SuccessHandler(
            tokenProvider = spyAuthenticationTokenProvider
        )
    }

    @Test
    internal fun onAuthenticationSuccess_get_token_by_AuthenticationTokenProvider() {
        val authentication = getAuthentication()
        oauth2SuccessHandler.onAuthenticationSuccess(
            getHttpServletRequest(),
            getHttpServletResponse(),
            authentication
        )

        assertThat(spyAuthenticationTokenProvider.generateTokenArguments).isEqualTo(authentication)
    }

    @Test
    internal fun onAuthenticationSuccess_add_authentication_cookie_to_response_by_generateToken_result() {
        val response = getHttpServletResponse()
        oauth2SuccessHandler.onAuthenticationSuccess(
            getHttpServletRequest(),
            response,
            getAuthentication()
        )

        val token = spyAuthenticationTokenProvider.generateTokenResult
        val cookie = response.getCookie("AUTH")
        assertThat(cookie).isNotNull
        assertThat(cookie!!.value).isEqualTo(token)
    }

}
