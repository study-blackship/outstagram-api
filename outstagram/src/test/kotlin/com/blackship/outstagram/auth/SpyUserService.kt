package com.blackship.outstagram.auth

import com.blackship.outstagram.user.UserDto
import com.blackship.outstagram.user.UserService
import com.blackship.outstagram.user.getUserDto

class SpyUserService: UserService {

    lateinit var getUserByResourceServerArgumentsResourceServerName: String
    lateinit var getUserByResourceServerArgumentsResourceServerId: String
    var getUserByResourceServerReturns: UserDto? = getUserDto()

    lateinit var registerUserArguments: UserDto
    var registerUserResult = getUserDto()
    override fun registerUser(userDto: UserDto): UserDto {
        registerUserArguments = userDto
        return registerUserResult
    }

    override fun getUserByResourceServer(
        resourceServerName: String,
        resourceServerId: String
    ): UserDto? {
        getUserByResourceServerArgumentsResourceServerName = resourceServerName
        getUserByResourceServerArgumentsResourceServerId = resourceServerId
        return getUserByResourceServerReturns
    }
}
