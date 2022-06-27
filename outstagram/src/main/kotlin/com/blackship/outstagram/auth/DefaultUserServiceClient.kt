package com.blackship.outstagram.auth

import com.blackship.outstagram.user.UserService
import org.springframework.stereotype.Component

@Component
class DefaultUserServiceClient(
    private val userService: UserService
): UserServiceClient {

    override fun getUserBy(
        resourceServerName: String,
        resourceServerId: String
    ): AuthUserDto {
        val userDto = userService.getUserByResourceServer(resourceServerName, resourceServerId)
        return AuthUserDto(
            id = userDto.id,
            resourceServerId = userDto.resourceServerId,
            resourceServerName = userDto.resourceServerName,
            email = userDto.email,
            profileImage = userDto.profileImage
        )
    }

}
