package com.blackship.outstagram.auth

interface UserServiceClient {

    fun getUserBy(resourceServerName: String, resourceServerId: String): AuthUserDto

}
