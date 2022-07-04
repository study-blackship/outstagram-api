package com.blackship.outstagram.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val resourceServerId: String,
    val resourceServerName: String,
    @Column(name = "email")
    private var _email: String,
    @Column(name = "profile_image")
    private var _profileImage: String
) {

    val email get() = _email
    val profileImage get() = _profileImage

}
