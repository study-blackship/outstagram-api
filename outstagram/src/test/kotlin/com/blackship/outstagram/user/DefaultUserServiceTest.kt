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
        val userDto = getUserDtoDummy()
        defaultUserService.registerUser(userDto)
        assertThat(spyUserMapper.toDomainByArguments).isEqualTo(userDto)
    }

}
