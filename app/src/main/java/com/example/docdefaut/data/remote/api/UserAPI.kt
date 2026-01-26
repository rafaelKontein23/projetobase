package com.example.docdefaut.data.remote.api

import com.example.docdefaut.data.remote.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path


// interface para retrofit
interface UserAPI {
    @GET("{id}/json")
    suspend fun getAddress(
        @Path("id") test: Int,
    ): UserResponse
}