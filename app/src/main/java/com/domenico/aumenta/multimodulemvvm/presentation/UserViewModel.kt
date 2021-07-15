package com.domenico.aumenta.multimodulemvvm.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.domenico.aumenta.core.utils.ApiResponse
import com.domenico.aumenta.multimodulemvvm.domain.GetUserUseCase
import com.domenico.aumenta.multimodulemvvm.model.User

class UserViewModel(
    private val userUseCase: GetUserUseCase,
    private val userListMapper: UserListMapper
) : ViewModel() {

    fun getUserListByReputation(): LiveData<ApiResponse<List<User>>> {

        val userRemoteListLiveData = userUseCase.getUserListByReputation()
        return Transformations.map(
            userRemoteListLiveData
        ) { response ->
            when (response.status) {
                ApiResponse.Status.SUCCESS -> {
                    ApiResponse.success(response.data?.users?.let { userListMapper.map(it) })
                }
                ApiResponse.Status.ERROR -> {
                    Log.d(TAG, "ERROR : ${response.message}")
                    response.message?.let { ApiResponse.error(it) }
                }
                ApiResponse.Status.LOADING -> {
                    ApiResponse.loading()
                }
                else -> null
            }
        }
    }

    companion object {
        val TAG: String = UserViewModel::class.java.simpleName
    }
}