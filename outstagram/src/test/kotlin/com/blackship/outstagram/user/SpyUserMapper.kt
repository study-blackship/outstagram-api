package com.blackship.outstagram.user

class SpyUserMapper: UserMapper() {

    lateinit var toDomainByArguments: UserDto

    override fun toDomainBy(userDto: UserDto): User {
        toDomainByArguments = userDto
        return getUserDummy()
    }

}
