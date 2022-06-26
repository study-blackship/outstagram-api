package com.blackship.outstagram.user

class UserDto(
    val id: Long? = null,
    val resourceServerId: String,
    val resourceServerName: String,
    val email: String,
    val profileImage: String
)
