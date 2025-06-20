package org.sopt.at.data.dataremote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetMyNickNameResponseDto(
    @SerialName("nickname") val nickname: String
)