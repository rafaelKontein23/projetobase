package com.example.docdefaut.domain.login.repository

import com.example.docdefaut.data.remote.model.UserResponse
// contrato para a camada de dados, dessa forma o use case não chama direto o repository
interface UserRemoteRepository {
     suspend fun getUser(id:Int):UserResponse
}