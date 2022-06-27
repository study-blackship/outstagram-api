package com.blackship.outstagram.user

import org.springframework.stereotype.Service

@Service
class DefaultUserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {

    override fun registerUser(userDto: UserDto) {
        userMapper.toDomainBy(userDto)
        // userDto to user by userMapper
        // saveUser
    }

    override fun getUserBy(): UserDto {
        TODO("Not yet implemented")
    }

}
