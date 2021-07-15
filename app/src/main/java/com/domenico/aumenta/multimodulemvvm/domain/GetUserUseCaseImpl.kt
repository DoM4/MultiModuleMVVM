package com.domenico.aumenta.multimodulemvvm.domain

import androidx.lifecycle.LiveData
import com.domenico.aumenta.core.model.RemoteUserResponse
import com.domenico.aumenta.core.utils.ApiResponse
import com.domenico.aumenta.multimodulemvvm.data.UserRepository

class GetUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserUseCase {
    override fun getUserListByReputation(): LiveData<ApiResponse<RemoteUserResponse>> {
        return userRepository.getUsersByReputation()
    }
}