package com.blackship.outstagram.user

internal fun getUserDummy(
    id: Long? = 1L,
    resourceServerId: String = "resourceServerId",
    resourceServerName: String = "resourceServerName",
    email: String = "email",
    profileImage: String = "profileImage"
) = User(
    id = id,
    resourceServerId = resourceServerId,
    resourceServerName = resourceServerName,
    _email = email,
    _profileImage = profileImage,
)

internal fun getUserDtoDummy(
    id: Long? = 1L,
    resourceServerId: String = "resourceServerId",
    resourceServerName: String = "resourceServerName",
    email: String = "email",
    profileImage: String = "profileImage"
) = UserDto(
    id = id,
    resourceServerId = resourceServerId,
    resourceServerName = resourceServerName,
    email = email,
    profileImage = profileImage
)
