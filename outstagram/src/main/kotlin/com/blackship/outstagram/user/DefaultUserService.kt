package com.blackship.outstagram.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultUserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {

    @Transactional
    override fun registerUser(userDto: UserDto) {
        val user = userMapper.toDomainBy(userDto)
        userRepository.save(user)
    }

    override fun getUserBy(): UserDto {
        TODO("Not yet implemented")
    }

}
