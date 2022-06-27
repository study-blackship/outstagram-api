package com.blackship.outstagram.user

interface UserService {

    fun registerUser(userDto: UserDto)

    fun getUserBy(
        resourceServerName: String,
        resourceServerId: String
    ): UserDto

}
