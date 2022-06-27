package com.blackship.outstagram.auth

class AuthUserDto(
    val id: Long? = null,
    val resourceServerId: String,
    val resourceServerName: String,
    val email: String,
    val profileImage: String
)
