package com.blackship.outstagram.user

import org.junit.jupiter.api.BeforeEach

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
//    @Test
//    internal fun registerUser_callsSave_inUserRepository() {
//        val user = getUserDummy()
//        defaultUserService.registerUser(user)
//        assertThat(spyUserRepository.saveArguments).isEqualTo(user)
//    }
}
