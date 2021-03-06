package com.blackship.outstagram.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DefaultUserServiceTest {

    private lateinit var spyUserRepository: SpyUserRepository
    private lateinit var spyUserMapper: SpyUserMapper
    private lateinit var defaultUserService: DefaultUserService

    @BeforeEach
    internal fun setUp() {
        spyUserRepository = SpyUserRepository()
        spyUserMapper = SpyUserMapper()

        defaultUserService = DefaultUserService(
            spyUserRepository,
            spyUserMapper
        )
    }

    @Test
    fun registerUser_callsToDomainBy_inUserMapper() {
        val userDto = getUserDto()
        defaultUserService.registerUser(userDto)
        assertThat(spyUserMapper.toDomainByArguments).isEqualTo(userDto)
    }

    @Test
    fun registerUser_callsSave_inUserRepository() {
        defaultUserService.registerUser(getUserDto())
        assertThat(spyUserRepository.saveArguments).isEqualTo(spyUserMapper.toDomainByResult)
    }

    @Test
    fun getUserByResourceServer_callsFindByResourceServerNameAndResourceServerId_inUserRepository() {
        val resourceServerName = "resourceServername"
        val resourceServerId = "resourceServerId"
        defaultUserService.getUserByResourceServer(resourceServerName, resourceServerId)
        assertThat(spyUserRepository.findByResourceServerNameAndResourceServerIdArgumentsResourceServerName).isEqualTo(resourceServerName)
        assertThat(spyUserRepository.findByResourceServerNameAndResourceServerIdArgumentsResourceServerId).isEqualTo(resourceServerId)
    }

    @Test
    fun getUserByResourceServer_callsToDtoBy_inUserMapper_by_findByResourceServerNameAndResourceServerId_result() {
        defaultUserService.getUserByResourceServer("resourceServerName", "resourceServerId")
        assertThat(spyUserMapper.toDtoByArguments).isEqualTo(spyUserRepository.findByResourceServerNameAndResourceServerIdReturns)
    }

    @Test
    fun getUserByResourceServer_returnsToDtoBy_inUserMapper() {
        val userDto = defaultUserService.getUserByResourceServer("resourceServerName", "resourceServerId")
        assertThat(userDto).isEqualTo(spyUserMapper.toDtoByResult)
    }

    @Test
    fun getUserByResourceServer_returnsNull_when_findByResourceServerNameAndResourceServerId_isNull() {
        spyUserRepository.findByResourceServerNameAndResourceServerIdReturns = null
        assertThat(defaultUserService.getUserByResourceServer("resourceServerName", "resourceServerId")).isNull()
    }

}
