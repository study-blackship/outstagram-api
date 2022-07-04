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

    @Transactional(readOnly = true)
    override fun getUserByResourceServer(
        resourceServerName: String,
        resourceServerId: String
    ): UserDto? {
        val user = userRepository.findByResourceServerNameAndResourceServerId(resourceServerName, resourceServerId)
        return if (user == null)
            null
        else
            userMapper.toDtoBy(user)
    }

}
