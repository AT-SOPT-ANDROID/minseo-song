package org.sopt.at.data.mapper.todomain

import org.sopt.at.data.dataremote.dto.response.GetMyNickNameResponseDto
import org.sopt.at.domain.model.GetMyNickNameResponseInfo

fun GetMyNickNameResponseDto.toDomain() = GetMyNickNameResponseInfo(
    nickname = this.nickname
)