package com.domenico.aumenta.multimodulemvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.domenico.aumenta.core.model.RemoteUserResponse
import com.domenico.aumenta.core.utils.ApiResponse
import com.domenico.aumenta.multimodulemvvm.domain.GetUserUseCase

class UserViewModel(
    val userUseCase: GetUserUseCase,
    val userListMapper: UserListMapper
) : ViewModel() {
    var userList: LiveData<ApiResponse<RemoteUserResponse>> = userUseCase.getUserListByReputation()

    companion object {
        val TAG: String = UserViewModel::class.java.simpleName
    }
}