package com.example.docdefaut.data.remote.repository

import com.example.docdefaut.data.remote.api.UserAPI
import com.example.docdefaut.data.remote.model.UserResponse
import com.example.docdefaut.domain.login.repository.UserRemoteRepository
import javax.inject.Inject


// aqui é a implementação da interface, que chama a api
class UserRemoteRepositoryImpl @Inject constructor (
    private val  api : UserAPI
): UserRemoteRepository {
    override suspend fun getUser(id: Int): UserResponse {
        return api.getAddress(id)
    }
}