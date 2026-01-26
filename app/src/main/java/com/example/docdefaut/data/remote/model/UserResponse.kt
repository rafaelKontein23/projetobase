package com.example.docdefaut.data.remote.model

import com.google.gson.annotations.SerializedName

// Aqui é a classe de objeto de retorno da api
data class UserResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("pass")
    val pass : String
)