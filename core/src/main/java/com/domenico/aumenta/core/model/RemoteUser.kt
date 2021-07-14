package com.domenico.aumenta.core.model

data class RemoteUser(
    val userId: Int,
    val aboutMe: String?,
    val acceptRate: Int,
    val accountId: Int,
    val answerCount: Int,
    val creationDate: Int,
    val displayName: String,
    val downVoteCount: Int,
    val isEmployee: Boolean,
    val lastAccessDate: Int,
    val lastModifiedDate: Int,
    val link: String,
    val location: String?,
    val profileImage: String,
    val questionCount: Int,
    val reputation: Int,
    val upVoteCount: Int,
    val userType: String,
    val viewCount: Int,
    val websiteUrl: String?
)