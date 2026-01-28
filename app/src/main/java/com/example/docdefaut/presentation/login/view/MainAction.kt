package com.example.docdefaut.presentation.login.view

sealed class LoginEvent {
    data class LoginTest(val email: String) : LoginEvent()
}

sealed class LoginEffect {
    object ShowLoading : LoginEffect()
}