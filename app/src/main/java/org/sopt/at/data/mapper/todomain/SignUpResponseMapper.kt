package org.sopt.at.data.mapper.todomain

import org.sopt.at.data.dataremote.dto.response.SignUpResponseDto
import org.sopt.at.domain.model.SignUpResponseInfo

fun SignUpResponseDto.toDomain() = SignUpResponseInfo(
    userId = this.userId,
    nickname = this.nickname
)