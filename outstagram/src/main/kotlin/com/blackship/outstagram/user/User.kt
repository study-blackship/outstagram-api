package com.blackship.outstagram.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
    private val resourceServerId: String,
    private val resourceServerName: String,
    private val email: String,
    private var profileImage: String

) {


}