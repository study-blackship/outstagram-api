package com.blackship.outstagram.auth

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DefaultUserServiceClientTest {

    private lateinit var defaultUserServiceClient: DefaultUserServiceClient
    private lateinit var spyUserService: SpyUserService

    @BeforeEach
    internal fun setUp() {
        spyUserService = SpyUserService()
        defaultUserServiceClient = DefaultUserServiceClient(
            spyUserService
        )
    }

    @Test
    fun getUserBy_callsGetUserByResourceServer_inUserService() {
        val resourceServerName = "resourceServerName"
        val resourceServerId = "resourceServerId"
        defaultUserServiceClient.getUserBy(resourceServerName, resourceServerId)
        assertThat(spyUserService.getUserByResourceServerArgumentsResourceServerName).isEqualTo(resourceServerName)
        assertThat(spyUserService.getUserByResourceServerArgumentsResourceServerId).isEqualTo(resourceServerId)
    }

    @Test
    fun getUserBy_returnsAuthUserDto_isConverted_fromUserDto() {
        val resourceServerName = "resourceServerName"
        val resourceServerId = "resourceServerId"
        val authUserDto = defaultUserServiceClient.getUserBy(resourceServerName, resourceServerId)!!
        val userDto = spyUserService.getUserByResourceServerReturns!!
        assertThat(authUserDto.id).isEqualTo(userDto.id)
        assertThat(authUserDto.email).isEqualTo(userDto.email)
        assertThat(authUserDto.profileImage).isEqualTo(userDto.profileImage)
        assertThat(authUserDto.resourceServerId).isEqualTo(userDto.resourceServerId)
        assertThat(authUserDto.resourceServerName).isEqualTo(userDto.resourceServerName)
    }

    @Test
    fun getUserBy_returnsNull_when_getUserByResourceServer_is_null() {
        spyUserService.getUserByResourceServerReturns = null
        val authUserDto = defaultUserServiceClient.getUserBy("resourceServerName", "resourceServerId")
        assertThat(authUserDto).isNull()
    }

}
