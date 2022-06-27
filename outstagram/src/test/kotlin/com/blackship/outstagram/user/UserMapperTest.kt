package com.blackship.outstagram.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserMapperTest {

    private val userMapper = UserMapper()

    @Test
    fun toDomainBy() {
        val userDto = UserDto(
            id = 1L,
            resourceServerId = "resourceServerId",
            resourceServerName = "resourceServerName",
            email = "email",
            profileImage = "profileImage"
        )
        val user = userMapper.toDomainBy(userDto)
        assertThat(user.id).isEqualTo(userDto.id)
        assertThat(user.resourceServerId).isEqualTo(userDto.resourceServerId)
        assertThat(user.resourceServerName).isEqualTo(userDto.resourceServerName)
        assertThat(user.email).isEqualTo(userDto.email)
        assertThat(user.profileImage).isEqualTo(userDto.profileImage)
    }

}
