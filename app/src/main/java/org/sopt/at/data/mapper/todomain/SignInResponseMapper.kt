package org.sopt.at.data.mapper.todomain

import org.sopt.at.data.dataremote.dto.response.SignInResponseDto
import org.sopt.at.domain.model.SignInResponseInfo

fun SignInResponseDto.toDomain() = SignInResponseInfo(
    userId = this.userId
)