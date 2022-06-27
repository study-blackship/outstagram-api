package com.blackship.outstagram.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DefaultUserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {

    override fun registerUser(userDto: UserDto) {
        val user = userMapper.toDomainBy(userDto)
        userRepository.save(user)
    }

    override fun getUserByResourceServer(
        resourceServerName: String,
        resourceServerId: String
    ): UserDto {
        // "get user by userRepository and convert to dto"
        return UserDto(
            null,
            "",
            "",
            "",
            ""
        )
    }

}
