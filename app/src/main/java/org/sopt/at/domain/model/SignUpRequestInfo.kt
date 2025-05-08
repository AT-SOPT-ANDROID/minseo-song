package org.sopt.at.domain.model

data class SignUpRequestInfo(
    val loginId: String,
    val password: String,
    val nickname: String
)