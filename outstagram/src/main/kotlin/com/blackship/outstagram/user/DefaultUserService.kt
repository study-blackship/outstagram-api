package com.blackship.outstagram.user

import org.springframework.stereotype.Service

@Service
class DefaultUserService(
    private val userRepository: UserRepository
) : UserService {

    override fun registerUser(user: User) {
        userRepository.save(user)
    }


}