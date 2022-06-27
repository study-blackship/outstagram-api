package com.blackship.outstagram.user

import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toDomainBy(userDto: UserDto) = User(
        id = userDto.id,
        resourceServerId = userDto.resourceServerId,
        resourceServerName = userDto.resourceServerName,
        _email = userDto.email,
        _profileImage = userDto.profileImage
    )

    fun toDtoBy(user: User): UserDto {
        return UserDto(
            null,
            "",
            "",
            "",
            ""
        )
    }

}
