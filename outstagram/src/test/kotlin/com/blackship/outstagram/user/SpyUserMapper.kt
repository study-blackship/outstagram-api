package com.blackship.outstagram.user

class SpyUserMapper: UserMapper() {

    lateinit var toDomainByArguments: UserDto
    var toDomainByResult = getUserDummy()

    override fun toDomainBy(userDto: UserDto): User {
        toDomainByArguments = userDto
        return toDomainByResult
    }

    lateinit var toDtoByArguments: User
    var toDtoByResult = getUserDto()
    override fun toDtoBy(user: User): UserDto {
        toDtoByArguments = user
        return toDtoByResult
    }
}
