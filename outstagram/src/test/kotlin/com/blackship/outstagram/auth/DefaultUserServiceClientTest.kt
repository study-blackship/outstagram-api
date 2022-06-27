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

}
