package com.domenico.aumenta.multimodulemvvm.presentation

import com.domenico.aumenta.core.model.RemoteUser
import com.domenico.aumenta.core.utils.Mapper
import com.domenico.aumenta.multimodulemvvm.model.User

class UserListMapper : Mapper<List<RemoteUser>, List<User>> {

    override fun map(input: List<RemoteUser>): List<User> {
        val userList = mutableListOf<User>()
        input.forEach {
            userList.add(mapUser(it))
        }
        return userList
    }

    fun mapUser(input: RemoteUser): User {
        return User(
            input.displayName,
            input.reputation,
            input.profileImage
        )
    }


}