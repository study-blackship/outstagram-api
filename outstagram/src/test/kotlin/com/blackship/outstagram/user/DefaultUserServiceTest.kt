package com.blackship.outstagram.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DefaultUserServiceTest {

    private lateinit var spyUserRepository: SpyUserRepository
    private lateinit var defaultUserService: DefaultUserService

    @BeforeEach
    internal fun setUp() {
        spyUserRepository = SpyUserRepository()

        defaultUserService = DefaultUserService(
            spyUserRepository
        )
    }

    @Test
    internal fun registerUser_callsSave_inUserRepository() {
        val user = getUserDummy()
        defaultUserService.registerUser(user)
        assertThat(spyUserRepository.saveArguments).isEqualTo(user)
    }

}