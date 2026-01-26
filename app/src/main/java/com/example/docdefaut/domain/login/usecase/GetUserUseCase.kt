package com.example.docdefaut.domain.login.usecase

import com.example.docdefaut.data.remote.mapper.toDomain
import com.example.docdefaut.data.remote.model.User
import com.example.docdefaut.domain.login.repository.UserRemoteRepository
import javax.inject.Inject

// camada de regra de negocio, e chama a camada de dados via interface
class GetUserUseCase @Inject constructor
    (
    private val repository: UserRemoteRepository
) {
    suspend operator fun invoke(id: Int): User {
        return repository.getUser(id).toDomain()
    }
}