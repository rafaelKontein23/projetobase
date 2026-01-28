package com.example.docdefaut.presentation.login.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.presenter.Event
import com.example.docdefaut.data.remote.model.User
import com.example.docdefaut.domain.login.usecase.GetUserUseCase
import com.example.docdefaut.presentation.login.view.LoginEffect
import com.example.docdefaut.presentation.login.view.LoginEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class viewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _effect = MutableLiveData<Event<LoginEffect>>()
    val effect: LiveData<Event<LoginEffect>> = _effect

    // exemplo de emissão de Effect
    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.LoginTest -> {
                _effect.value = Event(LoginEffect.ShowLoading)
            }
        }
    }

}