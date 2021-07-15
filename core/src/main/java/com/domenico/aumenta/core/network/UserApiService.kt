package com.domenico.aumenta.core.network

import androidx.lifecycle.LiveData
import com.domenico.aumenta.core.model.RemoteUserResponse
import com.domenico.aumenta.core.utils.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by domenicoaumenta on 2020-01-09.
 */
interface UserApiService {

    @GET("2.2/users")
    fun getUsersByReputation(
        @Query("pagesize") pageSize: Int = 100,
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "reputation",
        @Query("site") site: String = "stackoverflow"
    ): LiveData<ApiResponse<RemoteUserResponse>>

}