package com.blackship.outstagram.user

class UserDto(
    val id: Long? = null,
    val resourceServerId: String,
    val resourceServerName: String,
    val email: String,
    val profileImage: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserDto

        if (id != other.id) return false
        if (resourceServerId != other.resourceServerId) return false
        if (resourceServerName != other.resourceServerName) return false
        if (email != other.email) return false
        if (profileImage != other.profileImage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + resourceServerId.hashCode()
        result = 31 * result + resourceServerName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + profileImage.hashCode()
        return result
    }
}
