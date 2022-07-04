package com.blackship.outstagram.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByResourceServerNameAndResourceServerId(
        resourceServerName: String,
        resourceServerId: String
    ): User?

}
