package com.domenico.aumenta.core.model

import com.google.gson.annotations.SerializedName

data class RemoteUserResponse(
    @SerializedName("items")
    var users: List<RemoteUser>? = null,
    var hasMore: Boolean? = null,
    var quotaMax: Int? = null,
    var quotaRemaining: Int? = null
)

