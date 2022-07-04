package com.blackship.outstagram.user

import com.blackship.outstagram.auth.AuthUserDto
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.OAuth2AccessToken
import java.time.Instant

internal fun getUserDummy(
    id: Long? = 1L,
    resourceServerId: String = "resourceServerId",
    resourceServerName: String = "resourceServerName",
    email: String = "email",
    profileImage: String = "profileImage"
) = User(
    id = id,
    resourceServerId = resourceServerId,
    resourceServerName = resourceServerName,
    _email = email,
    _profileImage = profileImage,
)

internal fun getUserDto(
    id: Long? = 1L,
    resourceServerId: String = "resourceServerId",
    resourceServerName: String = "resourceServerName",
    email: String = "email",
    profileImage: String = "profileImage"
) = UserDto(
    id = id,
    resourceServerId = resourceServerId,
    resourceServerName = resourceServerName,
    email = email,
    profileImage = profileImage
)

internal fun getOAuth2UserRequest() = OAuth2UserRequest(
    ClientRegistration.withRegistrationId("google")
            .clientId("clientId")
            .clientSecret("clientSecret")
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .clientName("Google")
            .authorizationUri("https://authorizationUri")
            .userInfoUri("https://userInfoUri")
            .redirectUri("https://redirectUri")
            .tokenUri("https://tokenUri")
            .build(),
    OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER, "accessToken", Instant.EPOCH, Instant.MAX)
)

fun getAuthUserDto(
    id: Long? = null,
    resourceServerId: String = "resourceServerId",
    resourceServerName: String = "resourceServerName",
    email: String = "email",
    profileImage: String = "profileImage"
) = AuthUserDto(
    id = id,
    resourceServerId = resourceServerId,
    resourceServerName = resourceServerName,
    email = email,
    profileImage = profileImage
)
