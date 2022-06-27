package com.blackship.outstagram.user

class SpyUserMapper: UserMapper() {

    lateinit var toDomainByArguments: UserDto
    var toDomainByResult = getUserDummy()

    override fun toDomainBy(userDto: UserDto): User {
        toDomainByArguments = userDto
        return toDomainByResult
    }

}
