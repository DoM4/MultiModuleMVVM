package com.domenico.aumenta.multimodulemvvm.domain

import androidx.lifecycle.LiveData
import com.domenico.aumenta.core.model.RemoteUserResponse
import com.domenico.aumenta.core.utils.ApiResponse

interface GetUserUseCase {
    fun getUserListByReputation(): LiveData<ApiResponse<RemoteUserResponse>>
}