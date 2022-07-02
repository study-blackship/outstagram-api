package com.blackship.outstagram.user

interface UserService {

    fun registerUser(userDto: UserDto)

    fun getUserByResourceServer(
        resourceServerName: String,
        resourceServerId: String
    ): UserDto?

}
