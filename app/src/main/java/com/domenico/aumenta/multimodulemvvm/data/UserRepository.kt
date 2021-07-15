package com.domenico.aumenta.multimodulemvvm.data

import androidx.lifecycle.LiveData
import com.domenico.aumenta.core.model.RemoteUserResponse
import com.domenico.aumenta.core.network.UserApiService
import com.domenico.aumenta.core.utils.ApiResponse

class UserRepository(
    private val userApiService: UserApiService
) {
    fun getUsersByReputation(): LiveData<ApiResponse<RemoteUserResponse>> {
        return userApiService.getUsersByReputation()
    }
}