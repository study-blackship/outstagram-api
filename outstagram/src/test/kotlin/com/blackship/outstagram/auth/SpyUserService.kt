package com.blackship.outstagram.auth

import com.blackship.outstagram.user.UserDto
import com.blackship.outstagram.user.UserService
import com.blackship.outstagram.user.getUserDtoDummy

class SpyUserService: UserService {

    lateinit var getUserByResourceServerArgumentsResourceServerName: String
    lateinit var getUserByResourceServerArgumentsResourceServerId: String
    var getUserByResourceServerReturns: UserDto? = getUserDtoDummy()

    override fun registerUser(userDto: UserDto) {
        TODO("Not yet implemented")
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
