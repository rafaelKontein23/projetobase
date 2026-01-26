package com.example.docdefaut.data.remote.mapper

import com.example.docdefaut.data.remote.model.User
import com.example.docdefaut.data.remote.model.UserResponse

fun UserResponse.toDomain(): User {
    return User(
        name = name,
        pass = pass
    )
}