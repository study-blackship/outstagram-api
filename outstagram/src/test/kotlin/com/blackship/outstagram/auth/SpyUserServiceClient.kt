package com.blackship.outstagram.auth

import com.blackship.outstagram.user.getAuthUserDto

class SpyUserServiceClient: UserServiceClient {

    lateinit var getUserByArgumentsResourceServerName: String
    lateinit var getUserByArgumentsResourceServerId: String

    var getUserByResult: AuthUserDto? = getAuthUserDto()

    override fun getUserBy(
        resourceServerName: String,
        resourceServerId: String
    ): AuthUserDto? {
        getUserByArgumentsResourceServerName = resourceServerName
        getUserByArgumentsResourceServerId = resourceServerId
        return getUserByResult
    }

    var registerUserArguments: AuthUserDto? = null

    override fun registerUser(authUserDto: AuthUserDto) {
        registerUserArguments = authUserDto
    }

}
