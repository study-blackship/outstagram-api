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

    @Test
    fun toDtoBy() {
        val user = getUserDummy()
        val userDto = userMapper.toDtoBy(user)
        assertThat(userDto.id).isEqualTo(user.id)
        assertThat(userDto.resourceServerId).isEqualTo(user.resourceServerId)
        assertThat(userDto.resourceServerName).isEqualTo(user.resourceServerName)
        assertThat(userDto.email).isEqualTo(user.email)
        assertThat(userDto.profileImage).isEqualTo(user.profileImage)
    }

}
